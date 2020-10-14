<!DOCTYPE html> 
<html lang="en">
   <head>
      <meta charset="utf-8">
      <title>Home</title>
      <style type="text/css"><%@include file="../css/styles.css" %></style>
   </head>
   <body>
      <header>
      	 <!-- TOP MENU -->
         <div class="topnav">
            <h1>TainioProject</h1>
            <h1></h1> 
            <!-- API CALL ON KEY RELEASE -->
            <input type="text" placeholder="Search.." onkeyup="Apicall(document.getElementById('Search_value').value,'Short')" id="Search_value"> 
            <ul>
            
               <li>
	               <form action="/My_Bookmarks" method="POST">
		               <input type="hidden" name="user_email" value="${user_email}" />
		               <button>bookmarks</button>
	               </form>
               <li><a href="login">Logout</a></li>
               
            </ul>
         </div>
      </header>
      <main>
         <!-- MIDDLE MENU -->
         <div class="container" id="answer">
            <!-- POSTER -->
            <img id="movie_poster"src="">
            <div>
            
               <!-- TITLE -->
               
               <h1 id=movie_title> </h1>
               
               
               
               <!-- MOVIE INFO -->
               <h4 id=movie_genre> </h4>
               <h4 id=movie_actors> </h4><br><br>
               <h4 id=movie_desc> </h4>
               
               <!-- SHOW MORE (NEW API CALL FOR FULL DESC) -->
               <a href="#" id=movie_button onclick="Apicall(document.getElementById('Search_value').value,'Full');"></a>
               
               <!-- MOVIE ID (HIDDEN) -->
               <form action="/save" method="POST">
               
               
               		<input type='hidden' name='id' id="movie_id" value=''>
               		<input type='hidden' name='user_email' value='${user_email}'>
		            <!-- SAVE BUTTON -->
		            <br><button style="display: none;" class="saveButton" id="movie_save" ></button><br><br><br>
               
               </form>
              
               
               
               
            </div>
         </div>
      </main>
      <footer>
      </footer>
      <script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="crossorigin="anonymous"></script>
      <script>
      
        
        
       	function Apicall(title_to_search,plot){
	         var URL="https://www.omdbapi.com/?t="+title_to_search+"&apikey=7b20381c"+"&plot="+plot;
	         $.get(URL, function(response){
	         var data =JSON.parse(JSON.stringify(response));
	         
	         if (data.Response=="False"){
	        	 return;
	         }
	         
	         var title = data.Title;
	         var year = data.Year; 
	         var description = data.Plot;
	         var posterurl =data.Poster;
	         var genre = data.Genre;
	         var actors = data.Actors;
	         var id = data.imdbID;
	         
	         
	         document.getElementById('movie_poster').src=posterurl;
	         document.getElementById('movie_title').innerHTML =title;
	         document.getElementById('movie_genre').innerHTML ="Genre: "+genre;
	         document.getElementById('movie_actors').innerHTML ="Actors: "+actors;
	         document.getElementById('movie_desc').innerHTML =plot+ " Description: "+description;
	         var view_more = "View more";
	         if(plot=="Full")view_more = "" 
	         document.getElementById('movie_button').innerHTML =view_more;
	         document.getElementById('movie_save').innerHTML = "Save";
	         document.getElementById('movie_save').style="display: inline;"  
	         document.getElementById('movie_id').value = id;
	         });
         }
       	
       	
       	
       	

   		


         
         
         
      </script>
   </body>
</html>