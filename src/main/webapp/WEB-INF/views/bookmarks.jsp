<!DOCTYPE html> 
<html lang="en">
   <head>
      <meta charset="utf-8">
      <title>My Bookmarks</title>
     
      <style type="text/css"><%@include file="../css/styles.css" %></style>
   </head>
   <body>
      <header>
      	 <!-- TOP MENU -->
         <div class="topnav">
            <h1>Your saved movies</h1>
            <p hidden><font color="red" id="id_from_controller" >${id_from_controller}</font></p>
            <h1></h1> 
            
            <ul>
               <li><a href="#" onclick="goBack();">Home</a></li>
               <li><a href="login">Logout</a></li>
            </ul>
         </div>
      </header>
      <main >
	     <table width="100%" style="height: 100%;" border="0">
			 <tr>
		     	<td>
		     	<p id="photos">
		     		
		     		
		     	</p>
		     	</td>
			 </tr>
		 </table>

               

      </main>
      <footer>
      </footer>
      <script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="crossorigin="anonymous"></script>
<script>
		
		function Apicall(id_to_search){
			         var URL="https://www.omdbapi.com/?i="+id_to_search+"&apikey=7b20381c"+"&plot=short";
			         $.get(URL, function(response){
			         var data =JSON.parse(JSON.stringify(response));
			         console.log(data);
			         var title = data.Title;
			         var year = data.Year; 
			         var description = data.Plot;
			         var posterurl =data.Poster;
			         var genre = data.Genre;
			         var actors = data.Actors;
			         var id = data.imdbID;
			         
			         
		 		     var img = new Image();
		 		     img.height=400;
		 		     img.width=270;
		 		     img.src = posterurl;
		 		     img.id = id;
		 		     img.addEventListener('click', (e)=> {func(id);});
		 		     document.getElementById("photos").appendChild(img);
			         });
		         }
		
		
		
		function func(id){
			console.log(id);
		}
	
		function goBack(){
			 window.history.back();
		}
		
		var id = document.getElementById("id_from_controller").innerHTML;
		var movie_IDs = id.split(",");
		var arrayLength = movie_IDs.length;
		for(var i=0; i<arrayLength; i++){
			Apicall(movie_IDs[i]);
		}
		
		
		</script>
   </body>
</html>