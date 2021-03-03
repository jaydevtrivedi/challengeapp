# challengeapp

A Challenge app that loads information from [API](https://challenge.lexicondigital.com.au/) to show one approach to using some of the best practices in Android Development. Including:
 * ViewModel
 * LiveData
 * Hilt (for dependency injection)
 * Kotlin Coroutines
 * Retrofit
 * Navigation
 * Espresso(UI tests) + Hilt
 * Junit(local tests)
 
 The app is based on MVVM architecture.
 Fragment<->ViewModel<->Repository(RemoteDataSource only)
 
 The source code is in Kotlin using Anroid Studio
 The UI doesnt exactly match the document as it requires parent image so have added a title and name
 alongwith the recyclerview.  It can be modified into a grid adapter as and when required but have kept
 things simple atm.  The same goes for styling it can be done in consideration with what the designers
 wish to see.
 
 The streaming providers could be selected from the filter menu the details will be loaded according
 to the selected provider.
 
 ## You should also take a look at
 * [Guide to app architecture](https://developer.android.com/jetpack/guide)
 * [Android architecture samples](https://github.com/android/architecture-samples)

