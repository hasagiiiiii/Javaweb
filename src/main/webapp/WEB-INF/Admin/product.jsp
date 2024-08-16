<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
      rel="stylesheet"
    />
<link rel="stylesheet" href="css/product.css" type="text/css">
<link rel="stylesheet" href="css/main.css" type="text/css">
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
      integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
      crossorigin="anonymous"
      referrerpolicy="no-referrer"
    />
 <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<title>Insert title here</title>
</head>
<body>
	<%@include file="header.jsp"%>
 <div class="wrapper">
      <div class="top-content">
        <a href="/index.html">Trang chủ</a>
        <p id="url">/</p>
      </div>
      <div class="banner">
        <div class="item">
          <img
            width="100px"
            src="img/Middleton_Category-page_2-column-banner_desktop.png"
            alt=""
          />
          <h5 class="name">Loa Di Dong</h5>
          <p class="cout-product">1 product</p>
        </div>
        <div class="item">
          <img width="100px" src="img/backgroundBanner.png" alt="" />
          <h5 class="name">LOA NGHE TRONG NHÀ</h5>
          <p class="cout-product">18 product</p>
        </div>
        <div class="item">
          <img width="100px" src="img/TAINGHE-1.png" alt="" />
          <h5 class="name">Loa Di Dong</h5>
          <p class="cout-product">10 product</p>
        </div>
      </div>

      <!-- start menu -->
      <div class="Menu-marshall">
        <div class="side-bar-marshall">
          <h3>Lọc Sản Phẩm</h3>
          <span class="progress-before"></span>
          <div class="slider">
            <input
              type="range"
              min="0"
              max="1000"
              value="00"
              class="range-min"
              name=""
              id=""
            />
            <input
              type="range"
              min=" 0"
              max="1000"
              class="range-max"
              value="1000"
              name=""
              id=""
            />
          </div>
          <div class="prices">
            <h5>Giá:</h5>
            <p class="price-start">b</p>
            -
            <p class="price-stop">a</p>
            <button>Lọc</button>
          </div>
        </div>
        <div class="list-product">
          <div class="top-views">
            <h2>Loa Marshall</h2>
            <ul class="grid-show">
              <li>Show :</li>
              <li><a href="">9</a></li>
              <li><a href="">12</a></li>
              <li><a href="">18</a></li>
              <li>
                <a href=""><i class="fa-solid fa-bars"></i></a>
              </li>
              <select name="" id="">
                <option value="new">Mới nhất</option>
              </select>
            </ul>
          </div>
          <ul class="list-marshall">
            <li class="item">
              <div class="status">
                <div class="sale bg-dark text-white px-2 rounded-3">-19%</div>
                <div class="hot bg-danger mt-1 text-white px-2 rounded-3">
                  Hot
                </div>
                <div class="new bg-success mt-1 text-white px-2 rounded-3">
                  New
                </div>
              </div>
              <div class="action">
                <p title="compare" class="compare">
                  <i class="fa-solid fa-code-compare"></i>
                </p>
                <p title="Quick View" class="search">
                  <i class="fa-solid fa-magnifying-glass"></i>
                </p>
                <p title="add to wishlish" class="wishlish">
                  <i class="fa-regular fa-heart"></i>
                </p>
              </div>
              <div class="img-product">
                <img loading="lazy" src="img/Marshall-Major4.png" alt="" />
              </div>
              <div class="description">
                <h5 class="name">Marshall Major 4</h5>
                <p class="title">TAI NGHE MARSHALL, ON-EAR</p>
                <span class="evalute">
                  <i class="fa-regular fa-star"></i>
                  <i class="fa-regular fa-star"></i>
                  <i class="fa-regular fa-star"></i>
                  <i class="fa-regular fa-star"></i>
                </span>
                <br />
                <span class="stock">In stock</span>
                <div class="price">
                  <p class="cost">3.690.000 ₫</p>
                  <p class="price">2.990.000 ₫</p>
                </div>
                <div class="color"></div>
                <a class="w-100 overflow-hidden">
                  <p>Mua</p>
                  <i class="fa-solid fa-cart-shopping"></i>
                </a>
              </div>
            </li>

            <!--  -->
            
          </ul>
        </div>
      </div>
    </div>
</body>
<script type="text/javascript" src="js/product.js"></script>
<script >
	$(document).ready(function(){
		$.ajax({
		 url:"ApiProduct",
		 type:"GET",
		 success: function(res){
			 var productList = $(".list-marshall");

             // Xóa nội dung cũ trong phần tử userList
             productList.empty();
             
             // Lặp qua từng người dùng và thêm thông tin của họ vào phần tử userList
             $.each(res, function(index, res){
                 var urlImg = res.imgPro
                 var name = res.nameProduct
                 var price = res.price
                 var sale = res.sale
                 var total = price - (price*sale /100)
            	 var itemHtml = '<li class="item">' +
                 '<div class="status">' +
                   '<div class="sale bg-dark text-white px-2 rounded-3">'+ sale +'%</div>' +
                   '<div class="hot bg-danger mt-1 text-white px-2 rounded-3">Hot</div>' +
                   '<div class="new bg-success mt-1 text-white px-2 rounded-3">New</div>' +
                 '</div>' +
                 '<div class="action">' +
                   '<p title="compare" class="compare"><i class="fa-solid fa-code-compare"></i></p>' +
                   '<p title="Quick View" class="search"><i class="fa-solid fa-magnifying-glass"></i></p>' +
                   '<p title="add to wishlish" class="wishlish"><i class="fa-regular fa-heart"></i></p>' +
                 '</div>' +
                 '<div class="img-product">' +
                   '<img loading="lazy" src="img/'+urlImg+'" alt="" />' +
                 '</div>' +
                 '<div class="description">' +
                   '<h6 class="name">'+name+'</h6>' +
                   '<p class="title">TAI NGHE MARSHALL, ON-EAR</p>' +
                   '<span class="evalute">' +
                     '<i class="fa-regular fa-star"></i>' +
                     '<i class="fa-regular fa-star"></i>' +
                     '<i class="fa-regular fa-star"></i>' +
                     '<i class="fa-regular fa-star"></i>' +
                   '</span>' +
                   '<br />' +
                   '<span class="stock">In stock</span>' +
                   '<div class="price">' +
                     '<p class="cost">'+price+' ₫</p>' +
                     '<p class="price">'+total+' ₫</p>' +
                   '</div>' +
                   '<div class="color"></div>' +
                   '<a href="' + (isLogin ? 'Cart?id=' + res.id_product + '' : 'Login') + '" class="w-100 overflow-hidden"><p>Mua</p><i class="fa-solid fa-cart-shopping"></i></a>' +
                 '</div>' +
               '</li>';
            	console.log(res)
            	 productList.append(itemHtml);
                 // Thêm các thông tin khác của người dùng vào đây nếu cần
             });
			 }
		});
	});
</script>
</html>