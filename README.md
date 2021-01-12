# WordCounterAndroid


Book Word Counter using:
- Dagger2
- RX Kotlin
- Retrofit 

Copyright 2021 Andria Njoku


Screens:

Screen 1 : Book selection

Screen2: Word Count Screen

Here you can select the book to have its words counted.
Initially the app will make a call to get the book from the nertwork and will count the words.
The book will then be downloaded to the internal storage.
Once downloaded the app will load the book from the internal storage when counting words.

features: 

1. Word Counter 
2. isPrime : Will calculate if the number of times each word occurs is a prime number.
3. Book download indicator: Shows green when the book has been downloaded and red when not.

Unit testing :

There are unit tests for all use cases and presenters.

Extensions:

The app is designed to be able to add any book available in .txt format on the internet.

How to add additional books:

1. Add predicate to select a new base url if it differs from the exiating one provided by retrofit
3. Add the new book to the BOOKS enum 
4. Add a method to presenter for the book 
4. Add a branch to the when in the getBookLocal/ getBookNet then define the local file name and the endpoint to fetch the book using retrofit

