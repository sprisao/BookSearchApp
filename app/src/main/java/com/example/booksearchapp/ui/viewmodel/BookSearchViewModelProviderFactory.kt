package com.example.booksearchapp.ui.viewmodel

//class BookSearchViewModelProviderFactory(
//    private val bookSearchRepository: BookSearchRepository
//) : ViewModelProvider.Factory {
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(BookSearchViewModel::class.java)) {
//            return BookSearchViewModel(bookSearchRepository) as T
//        }
//        throw IllegalArgumentException("ViewModel class not found")
//    }
//}
//

//class BookSearchViewModelProviderFactory(
//    private val bookSearchRepository: BookSearchRepository,
//    private val workManager: WorkManager,
//    owner: SavedStateRegistryOwner,
//    defaultArgs: Bundle? = null
//) : AbstractSavedStateViewModelFactory(owner, defaultArgs) {
//    override fun <T : ViewModel> create(
//        key: String,
//        modelClass: Class<T>,
//        handle: SavedStateHandle
//    ): T {
//        if (modelClass.isAssignableFrom(BookSearchViewModel::class.java)) {
//            return BookSearchViewModel(bookSearchRepository, handle, workManager) as T
//        }
//        throw IllegalArgumentException("ViewModel class not found")
//    }
//}
