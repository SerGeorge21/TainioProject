<!DOCTYPE HTML>
<html lang="en">
  <head>
    <title>Sign Up Now!</title>
    <style type="text/css"><%@include file="../css/sign-up-form-style.css" %></style>
  </head>
  <body>

    <div class="sign-up-form">
      <h1>TainioProject</h1>
      <form action="/login" method="POST">
      
        <input name="user_email" type="email" class="input-box" placeholder="Your Email">
        <input name="user_password" type="password" class="input-box" placeholder="Your Password">
        <p><font color="red">${errorMessage}</font></p>
        <button type="submit" class="sign-button" id="sign-in-btn">Sign in</button>
        
        <hr>
        <p><a href="register">Register now</a></p>
        <p><a href="#">Forgot your password?</a></p>
        
      </form>
    </div>


  </body>
</html>





