Since I had to test two main endpoints of the API - FAV
QUOTE and LIST QUOTES, I have created two java files to create test cases for each endpoint. I have also created baseTest.java which helps in storing the API key that I generated for my account and also contains the baseURI that is used to test the endpoints.

Below are the methods in each class:


1. favQuotes.java :
  1.1. testInvalidAuthorization() - This method checks if the reponse code is 401 for invalid API.
  1.2. testFavQuote() - This method is used to favourite a quote by passing a quote_Id (I have used 4 in my testase)
  1.3. testUnfavQuote() - This method is used to remove favourite flag from a quote by passing a quote_Id (I have used 7 in my testase)


2. listQuotes.java  :
   2.1. testQuotesContainingWord() - This method is used to search for quotes containing the word "funny" by using parameter name = filter.
   2.2. testQuotesWithTag() - This method is used to search for quotes that are tagged "funny"  by using parameter filter = funny and type = tag.
   2.3. testQuotesByAuthor() - This method is used to search for quotes by "Mark Twain"  by using parameter filter = Mark Twain and type = author.
   2.4. testPublicQuotesByUser() - This method is used to search for quotes by "gose"  by using parameter filter = gose and type = user.
   2.5. testPrivateQuotes() - This method is used to search for quotes containing "little book"  by using parameter filter = little book and private = 1.
   2.6. testHiddenQuotes() - This method is used to search for hidden quotes by using parameter hidden = 1.

All of these test cases assert a status code of 200 and fails if the response code is anything else.

Uncovered Scenarios -
1. When we try to flag a Quote as favorite, if the Quote is already favourite, a test case can be created to handle the response code.
2. A test case to flag a private Quote as favorite would return error code 41.
