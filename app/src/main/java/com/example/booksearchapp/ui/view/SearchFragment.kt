package com.example.booksearchapp.ui.view

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.booksearchapp.databinding.FragmentSearchBinding
import com.example.booksearchapp.ui.adapter.BookSearchLoadStateAdapter
import com.example.booksearchapp.ui.adapter.BookSearchPagingAdapter
import com.example.booksearchapp.ui.viewmodel.BookSearchViewModel
import com.example.booksearchapp.util.Constants.SEARCH_BOOKS_TIME_DELAY
import com.example.booksearchapp.util.collectLatestStateFlow
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment() {
    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    //    private lateinit var bookSearchViewModel: BookSearchViewModel
    private val bookSearchViewModel by activityViewModels<BookSearchViewModel>()
//    private lateinit var bookSearchAdapter: BookSearchAdapter

    private lateinit var bookSearchAdapter: BookSearchPagingAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        bookSearchViewModel = (activity as MainActivity).bookSearchViewModel

        setupRecyclerView()
        searchBooks()
        setupLoadState()

//        bookSearchViewModel.searchResult.observe(viewLifecycleOwner) { response ->
//            val books = response.documents
//            bookSearchAdapter.submitList(books)

        collectLatestStateFlow(bookSearchViewModel.searchPagingResult) {
            bookSearchAdapter.submitData(it)
        }

    }

    private fun setupRecyclerView() {
//        bookSearchAdapter = BookSearchAdapter()
        bookSearchAdapter = BookSearchPagingAdapter()

        binding.rvSearchResult.apply {
            setHasFixedSize(true)
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            addItemDecoration(
                DividerItemDecoration(
                    requireContext(),
                    DividerItemDecoration.VERTICAL
                )
            )

//            adapter = bookSearchAdapter
            adapter = bookSearchAdapter.withLoadStateFooter(
                footer = BookSearchLoadStateAdapter { bookSearchAdapter::retry }
            )

        }
        bookSearchAdapter.setOnItemClickListener {
            findNavController().navigate(
                SearchFragmentDirections.actionFragmentSearchToFragmentBook(it)
            )
        }
    }

    private fun searchBooks() {
        var startTime = System.currentTimeMillis()
        var endTime: Long

        binding.etSearch.text =
            Editable.Factory.getInstance().newEditable(bookSearchViewModel.query)

        binding.etSearch.addTextChangedListener { text: Editable? ->
            endTime = System.currentTimeMillis()
            if (endTime - startTime >= SEARCH_BOOKS_TIME_DELAY) {
                text?.let {
                    val query = it.toString().trim()
                    if (query.isNotEmpty()) {
//                        bookSearchViewModel.searchBooks(query)

                        bookSearchViewModel.searchBooksPaging(query)
                        /*save query in savedstatehandler*/
                        bookSearchViewModel.query = query
                    }
                }
            }
            startTime = endTime
        }
    }

    private fun setupLoadState() {
        bookSearchAdapter.addLoadStateListener { combinedLoadState ->
            val loadState = combinedLoadState.source
            val isListEmpty =
                bookSearchAdapter.itemCount < 1 && loadState.refresh is LoadState.NotLoading && loadState.append.endOfPaginationReached

            binding.tvEmptylist.isVisible = isListEmpty
            binding.rvSearchResult.isVisible = !isListEmpty
            binding.progressBar.isVisible = loadState.refresh is LoadState.Loading


            /* LoadStateFooter 적용 이후로 필요 없으므로 주석처리 */
//            binding.btnRetry.isVisible =
//                loadState.refresh is LoadState.Error || loadState.append is LoadState.Error || loadState.prepend is LoadState.Error
//
//            val errorState: LoadState.Error? =
//                loadState.refresh as? LoadState.Error ?: loadState.append as? LoadState.Error
//                ?: loadState.prepend as? LoadState.Error
//            errorState?.let {
//                Toast.makeText(requireContext(), it.error.message, Toast.LENGTH_SHORT).show()
//            }
        }
//        binding.btnRetry.setOnClickListener {
//            bookSearchAdapter.retry()
//        }
    }


    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}
