#### Assignment 1
* Create a new Android Application to capture the following data from the user and to store it using sharedpreferences.
  * Create 5 EditTexts for name,rollnumber,email,phone number and password (hint : use inputType ).
  * Create 2 Spinners to select branch and year (hint : use string-array ).
  * Create Radio Buttons for gender.
  * Create CheckBoxes to select languages(Add any 3 languages).
  * Create an Image Button to save the data

#### Assignment 2
* Create a new Android Application to connect with the Firebase.
  * Create a login screen ( One time authentication )( email and password authentication only ).
  * Create a Registration Screen with reference to Assignment-1.
  * Store the data in the Firebase Realtime Database.
  * Create a profile Screen and display the complete data in the profile screen by fetching it from the Firebase Realtime Database.
  * Profile Data can be editable ( hint : Use update threading operation )
  
#### Assignment 3
* With the continuation of the Assignment-2 add image to the profile using Firebase Storage.
* Also display the image in the user profile screen
* Image should be dynamic and user should have permission to update the image.

### Sample Project
* Create a new android application to complete this project described below :
  * Create a login screen and registration screen for user to authenticate himself ( Try to follow good material design )
  * Add firebase for the authentication of the user (You can add any way of authentication process , use 3 ways if possbile)
  * Make sure authenication is only one time for the application.
  * Add firebase database and storage to capture the data from the user.
  * Allow user to add image of any book he likes and can write a review on it.
  * And the books added by the user should be displayed to every user with that application.
  * Add an menu at the top and by clicking on it user will be navigate to next screen , where he will displayed with multiple books from the online.
  * Use the retrofit , Json parsing and work with the books api and display book image and the book name in the recyclerview. 
  * ( Link : https://www.googleapis.com/books/v1/volumes?q=c )
  * Create a layout file to display an image and text in each item (row.xml).
  * By clicking on any book user should navigate to complete new display activity
  * Make user can see author name,book title,book image , book publisher and published date in that acitivty.
  * And add a button to navigate into static payment in the display acitivity.
  * Also display adds at the top and bottom of the screens in the application ( use static admob id and use only banner ads )
  * Add a logout button in the menu,by clicking on it user should logout of the application.
###### Optional :
  * Use Fragments and display book details in the fragment.
  * Add Edit text to the books api screen , so that user can search whatever the books he want.
  * Try to do application using fragments if possible.
