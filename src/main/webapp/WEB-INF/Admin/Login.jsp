<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
 
<link rel="stylesheet" href="css/login.css" type="text/css">
<link rel="stylesheet" href="css/main.css" type="text/css">
<title>Login</title>
</head>
<body>
		<%@include file="header.jsp"%>
			
		<div class="form">
    <ul class="tab-group">
       <div class="wrapp">
        <li class="tab active "><a href="#login" style="border-radius: 15px!important;margin-right:8px;">Log In</a></li>
        <li class="tab"><a href="#signup" style="border-radius: 15px!important;margin-left:8x;">Sign Up</a></li>
       </div>
        <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Explicabo excepturi, suscipit nostrum, nobis necessitatibus distinctio voluptates dolore laboriosam consectetur quos vero placeat itaque dicta animi quam consequuntur debitis mollitia? Neque.</p>
    </ul>
    <p style="color: red;">${errorLogin}</p>
    <div class="tab-content">
      <div id="signup">
        <h1>Register</h1>
        <form action="Register" method="post">
          <div class="top-row">
            <div class="field-wrap">
              <input type="text" required name="firstName" placeholder="First Name" />
            </div>
            <div class="field-wrap">
              <input type="text" name="lastName" required placeholder="Last Name" />
            </div>
          </div>
          <div class="field-wrap">
            <input type="text" required name="username" placeholder="User Name"/>
          </div>
          <div class="field-wrap">
            <input type="password" name="password" required placeholder="Password" />
          </div>
          <button type="submit" class="button button-block" />Sign Up</button>
        </form>
      </div>
      <div id="login">
        <h1>Login</h1>
        <form action="Login" method="post">
          <div class="field-wrap">
            <input type="text" required name="username" placeholder="User Name" />
          </div>
          <div class="field-wrap">
            <input type="password" required name="password" placeholder="Password" />
          </div>
          <p class="forgot"><a href="https://www.web-leb.com/code">Forgot Password?</a></p>
          <button class="button button-block" />Login</button>
         
        </form>
      </div>
    </div>
  </div> 
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script>
    $('.form').find('input, textarea').on('keyup blur focus', function (e) {
  
  var $this = $(this),
      label = $this.prev('label');

      if (e.type === 'keyup') {
            if ($this.val() === '') {
          label.removeClass('active highlight');
        } else {
          label.addClass('active highlight');
        }
    } else if (e.type === 'blur') {
        if( $this.val() === '' ) {
            label.removeClass('active highlight'); 
            } else {
            label.removeClass('highlight');   
            }   
    } else if (e.type === 'focus') {
      
      if( $this.val() === '' ) {
            label.removeClass('highlight'); 
            } 
      else if( $this.val() !== '' ) {
            label.addClass('highlight');
            }
    }

});

$('.tab a').on('click', function (e) { // lấy tất cả a trong phần tử cha là tab
  
  e.preventDefault(); // ngăn chặn hành động redirect đến của atribute href
  
  $(this).parent().addClass('active'); // thêm class acitve vào phần tử cha của thẻ a
  $(this).parent().siblings().removeClass('active');  // xóa bỏ class active của các phần tử cùng cấp cha của thẻ a và trừ thẻ a đã được chọn
  
  target = $(this).attr('href'); // lấy href của thẻ a

  $('.tab-content > div').not(target).hide(); // ẩn đi các thẻ div không có id === target
  
  $(target).fadeIn(600);
  
});

  </script>
</body>
</html>