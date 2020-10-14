<!DOCTYPE HTML>
<html lang="en">
  <head>
    <title>Sign Up Now!</title>
    <style type="text/css"><%@include file="../css/sign-up-form-style.css" %></style>
  </head>
  <body>
    <div class="sign-up-form">
      <h1>Sign Up</h1>
      <form action="/register" method="POST">
      
        <input name="user_email" type="email" class="input-box" placeholder="Your Email">
        <input name="user_password" type="password" class="input-box" placeholder="Your Password">
        <input name="passconfirm" type="password" class="input-box" placeholder="Your Password" placeholder="Confirm Password">
        <p><font color="red">${errorMessage}</font></p>
        <p><span><input type="checkbox"></span> I agree to terms of services</p>
        <button type="submit">Sign up</button>
         
        <hr>
        <p>Do you have an account? <a href="login">Sign in</a></p>
      </form>
    </div>


  </body>
</html>
