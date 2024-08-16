<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
 <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
      rel="stylesheet"
    />
    <!-- Bootstrap JS bundle (includes Popper) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
    
<link rel="stylesheet" href="css/main.css" type="text/css">
<link rel="stylesheet" href="css/home.css" type="text/css">
<title>Insert title here</title>
</head>
<body>
	<%@include file="header.jsp"%>
	    <!-------------------------Start Banner--------------------------------->

    <article>
      <div class="banner">
        <div
          id="carouselExampleCaptions"
          class="carousel slide"
          data-bs-ride="carousel"
          data-bs-interval="2000"
        >
          <div class="carousel-indicators">
            <button
              type="button"
              data-bs-target="#carouselExampleCaptions"
              data-bs-slide-to="0"
              class="active"
              aria-current="true"
              aria-label="Slide 1"
            ></button>
            <button
              type="button"
              data-bs-target="#carouselExampleCaptions"
              data-bs-slide-to="1"
              aria-label="Slide 2"
            ></button>
            <button
              type="button"
              data-bs-target="#carouselExampleCaptions"
              data-bs-slide-to="2"
              aria-label="Slide 3"
            ></button>
          </div>
          <div class="carousel-inner">
            <div class="carousel-item active">
              <img
                src="img/hero-all-speakers-desktop.jpeg"
                class="d-block w-100"
                alt="..."
              />
              <div class="carousel-caption d-none d-md-block">
                <h5>All Speaker</h5>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                <a href="">Shop Now</a>
              </div>
            </div>
            <div class="carousel-item">
              <img
                src="img/01-Hero-Desktop-1200x688.jpeg"
                class="d-block w-100"
                alt="..."
              />
              <div class="carousel-caption d-none d-md-block">
                <h5>Second slide label</h5>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                <a href="">Shop Now</a>
              </div>
            </div>
            <div class="carousel-item">
              <img
                src="img/hero-all-speakers-desktop.jpeg"
                class="d-block w-100"
                alt="..."
              />
              <div class="carousel-caption d-none d-md-block">
                <h5>Third slide label</h5>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                <a href="">Shop Now</a>
              </div>
            </div>
          </div>
          <button
            class="carousel-control-prev"
            type="button"
            data-bs-target="#carouselExampleCaptions"
            data-bs-slide="prev"
          >
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
          </button>
          <button
            class="carousel-control-next"
            type="button"
            data-bs-target="#carouselExampleCaptions"
            data-bs-slide="next"
          >
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
          </button>
        </div>
      </div>
    </article>
    <!-------------------------Stop Banner--------------------------------->

    <!--  -->

    <section>
      <div class="container">
        
        <!-------------------------Start Hot Deals--------------------------------->
        <div class="hot-deals-marshall">
          <div class="Title">
            <h4 class="sub-title">Sản Phẩm Hot</h4>
            <a href=""> Xem tất cả <i class="fa-solid fa-chevron-right"></i></a>
          </div>
          <ul class="list-marshall">
            <li class="item">
              <div class="status">
                <div class="sale bg-dark text-white px-2 rounded-3 ">-19%</div>
                <div class="hot bg-danger mt-1  text-white px-2 rounded-3 ">Hot</div>
                <div class="new bg-success mt-1  text-white px-2 rounded-3 ">New</div>
              </div>
              <div class="action">
                  <p title="compare" class="compare"><i class="fa-solid fa-code-compare"></i></p>
                  <p title="Quick View" class="search"><i class="fa-solid fa-magnifying-glass"></i></p>
                  <p title="add to wishlish" class="wishlish"><i class="fa-regular fa-heart"></i></p>
              </div>
              <div class="img-product">
                <img loading="lazy" src="img/Marshall-Major4.png"  alt="" />
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
                <br>
                <span class="stock">In stock</span>
                <div class="price">
                  <p class="cost">3.690.000 ₫</p>
                  <p class="price">2.990.000 ₫</p>
                </div>
                <div class="color"></div>
                <a class="w-100 overflow-hidden ">
                  <p>Mua</p>
                  <i class="fa-solid fa-cart-shopping"></i>
                </a>
              </div>
            </li>
           
            <!--  -->
            <li class="item">
              <div class="status">
                <div class="sale bg-dark text-white px-2 rounded-3 ">-19%</div>
                <div class="hot bg-danger mt-1  text-white px-2 rounded-3 ">Hot</div>
                <div class="new bg-success mt-1  text-white px-2 rounded-3 ">New</div>
              </div>
              <div class="action">
                  <p title="compare" class="compare"><i class="fa-solid fa-code-compare"></i></p>
                  <p title="Quick View" class="search"><i class="fa-solid fa-magnifying-glass"></i></p>
                  <p title="add to wishlish" class="wishlish"><i class="fa-regular fa-heart"></i></p>
              </div>
              <div class="img-product">
                <img loading="lazy" src="img/marshall-stanmore-iii-black-01.webp"  alt="" />
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
                <br>
                <span class="stock">In stock</span>
                <div class="price">
                  <p class="cost">3.690.000 ₫</p>
                  <p class="price">2.990.000 ₫</p>
                </div>
                <div class="color"></div>
                <a class="w-100 overflow-hidden ">
                  <p>Mua</p>
                  <i class="fa-solid fa-cart-shopping"></i>
                </a>
              </div>
            </li>
            <!--  -->
            <li class="item">
              <div class="status">
                <div class="sale bg-dark text-white px-2 rounded-3 ">-19%</div>
                <div class="hot bg-danger mt-1  text-white px-2 rounded-3 ">Hot</div>
                <div class="new bg-success mt-1  text-white px-2 rounded-3 ">New</div>
              </div>
              <div class="action">
                  <p title="compare" class="compare"><i class="fa-solid fa-code-compare"></i></p>
                  <p title="Quick View" class="search"><i class="fa-solid fa-magnifying-glass"></i></p>
                  <p title="add to wishlish" class="wishlish"><i class="fa-regular fa-heart"></i></p>
              </div>
              <div class="img-product">
                <img loading="lazy" src="img/marshall-woburn-iii-black-01.webp"  alt="" />
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
                <br>
                <span class="stock">In stock</span>
                <div class="price">
                  <p class="cost">3.690.000 ₫</p>
                  <p class="price">2.990.000 ₫</p>
                </div>
                <div class="color"></div>
                <a class="w-100 overflow-hidden ">
                  <p>Mua</p>
                  <i class="fa-solid fa-cart-shopping"></i>
                </a>
              </div>
            </li>
            <!--  -->
            <li class="item">
              <div class="status">
                <div class="sale bg-dark text-white px-2 rounded-3 ">-19%</div>
                <div class="hot bg-danger mt-1  text-white px-2 rounded-3 ">Hot</div>
                <div class="new bg-success mt-1  text-white px-2 rounded-3 ">New</div>
              </div>
              <div class="action">
                  <p title="compare" class="compare"><i class="fa-solid fa-code-compare"></i></p>
                  <p title="Quick View" class="search"><i class="fa-solid fa-magnifying-glass"></i></p>
                  <p title="add to wishlish" class="wishlish"><i class="fa-regular fa-heart"></i></p>
              </div>
              <div class="img-product">
                <img loading="lazy" src="img/marshall-woburn-iii-cream-02.webp"  alt="" />
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
                <br>
                <span class="stock">In stock</span>
                <div class="price">
                  <p class="cost">3.690.000 ₫</p>
                  <p class="price">2.990.000 ₫</p>
                </div>
                <div class="color"></div>
                <a class="w-100 overflow-hidden ">
                  <p>Mua</p>
                  <i class="fa-solid fa-cart-shopping"></i>
                </a>
              </div>
            </li>
          </ul>
        </div>
        <!-------------------------Start Detail MarShall--------------------------------->
        <div class="detail1">
          <div class="img_midleton">
            <img loading="lazy" width="700" src="img/Middleton_Category-page_2-column-banner_desktop.png" alt="">
          </div>
          <div class="left_mideleton">
            <h1 class="left_mideleton_h1">Loa Di Động</h1>
            <p class="left_mideleton_p">Mang âm thanh đặc trưng của Marshall đi khắp mọi nơi bằng loa di động và giữ cho âm nhạc của bạn tiếp tục hàng giờ liền.</p>
            <button class="left_mideleton_button">Xem Thêm <i class="fa-solid fa-chevron-right"></i></button>
          </div> 
        </div>

      <!---------------------MarShall New-------------------------->
      <div class="marshall-new">
        <div class="left-content">
          <p class="title">AT A GOOD PRICE</p>
          <h1>Emberton II</h1>
          <div class="banner">
            <img src="img/banner.jpeg" alt="">
          </div>
        </div>
        <div class="right-content">
          <div class="Title">
            <h4 class="sub-title">SẢN PHẨM MỚI DÒNG LOA DI ĐỘNG</h4>
            <a href=""> Xem tất cả <i class="fa-solid fa-chevron-right"></i></a>
          </div>
          <ul class="list-marshall">
            <li class="item">
              <div class="status">
                <div class="sale bg-dark text-white px-2 rounded-3 ">-19%</div>
                <div class="hot bg-danger mt-1  text-white px-2 rounded-3 ">Hot</div>
                <div class="new bg-success mt-1  text-white px-2 rounded-3 ">New</div>
              </div>
              <div class="action">
                  <p title="compare" class="compare"><i class="fa-solid fa-code-compare"></i></p>
                  <p title="Quick View" class="search"><i class="fa-solid fa-magnifying-glass"></i></p>
                  <p title="add to wishlish" class="wishlish"><i class="fa-regular fa-heart"></i></p>
              </div>
              <div class="img-product">
                <img loading="lazy" src="img/Marshall-Major4.png"  alt="" />
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
                <br>
                <span class="stock">In stock</span>
                <div class="price">
                  <p class="cost">3.690.000 ₫</p>
                  <p class="price">2.990.000 ₫</p>
                </div>
                <div class="color"></div>
                <a class="w-100 overflow-hidden ">
                  <p>Mua</p>
                  <i class="fa-solid fa-cart-shopping"></i>
                </a>
              </div>
            </li>
           
            <!--  -->
            <li class="item">
              <div class="status">
                <div class="sale bg-dark text-white px-2 rounded-3 ">-19%</div>
                <div class="hot bg-danger mt-1  text-white px-2 rounded-3 ">Hot</div>
                <div class="new bg-success mt-1  text-white px-2 rounded-3 ">New</div>
              </div>
              <div class="action">
                  <p title="compare" class="compare"><i class="fa-solid fa-code-compare"></i></p>
                  <p title="Quick View" class="search"><i class="fa-solid fa-magnifying-glass"></i></p>
                  <p title="add to wishlish" class="wishlish"><i class="fa-regular fa-heart"></i></p>
              </div>
              <div class="img-product">
                <img loading="lazy" src="img/marshall-stanmore-iii-black-01.webp"  alt="" />
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
                <br>
                <span class="stock">In stock</span>
                <div class="price">
                  <p class="cost">3.690.000 ₫</p>
                  <p class="price">2.990.000 ₫</p>
                </div>
                <div class="color"></div>
                <a class="w-100 overflow-hidden ">
                  <p>Mua</p>
                  <i class="fa-solid fa-cart-shopping"></i>
                </a>
              </div>
            </li>
            <!--  -->
            <li class="item">
              <div class="status">
                <div class="sale bg-dark text-white px-2 rounded-3 ">-19%</div>
                <div class="hot bg-danger mt-1  text-white px-2 rounded-3 ">Hot</div>
                <div class="new bg-success mt-1  text-white px-2 rounded-3 ">New</div>
              </div>
              <div class="action">
                  <p title="compare" class="compare"><i class="fa-solid fa-code-compare"></i></p>
                  <p title="Quick View" class="search"><i class="fa-solid fa-magnifying-glass"></i></p>
                  <p title="add to wishlish" class="wishlish"><i class="fa-regular fa-heart"></i></p>
              </div>
              <div class="img-product">
                <img loading="lazy" src="img/marshall-woburn-iii-black-01.webp"  alt="" />
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
                <br>
                <span class="stock">In stock</span>
                <div class="price">
                  <p class="cost">3.690.000 ₫</p>
                  <p class="price">2.990.000 ₫</p>
                </div>
                <div class="color"></div>
                <a class="w-100 overflow-hidden ">
                  <p>Mua</p>
                  <i class="fa-solid fa-cart-shopping"></i>
                </a>
              </div>
            </li>
            <!--  -->
            <li class="item">
              <div class="status">
                <div class="sale bg-dark text-white px-2 rounded-3 ">-19%</div>
                <div class="hot bg-danger mt-1  text-white px-2 rounded-3 ">Hot</div>
                <div class="new bg-success mt-1  text-white px-2 rounded-3 ">New</div>
              </div>
              <div class="action">
                  <p title="compare" class="compare"><i class="fa-solid fa-code-compare"></i></p>
                  <p title="Quick View" class="search"><i class="fa-solid fa-magnifying-glass"></i></p>
                  <p title="add to wishlish" class="wishlish"><i class="fa-regular fa-heart"></i></p>
              </div>
              <div class="img-product">
                <img loading="lazy" src="img/marshall-woburn-iii-cream-02.webp"  alt="" />
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
                <br>
                <span class="stock">In stock</span>
                <div class="price">
                  <p class="cost">3.690.000 ₫</p>
                  <p class="price">2.990.000 ₫</p>
                </div>
                <div class="color"></div>
                <a class="w-100 overflow-hidden ">
                  <p>Mua</p>
                  <i class="fa-solid fa-cart-shopping"></i>
                </a>
              </div>
            </li>
          </ul>
        </div>
      </div>
      </div>
       <!-- -----------------MarShall In House ---------------------- -->
       <div class="marshall-house">
        <div class="top-marshall-house">
          <div class="img-marshall-house">
            <img loading="lazy" width="750px" src="img/backgroundBanner.png" alt="">
          </div>
          <div class="content-marshall-house">
            <h1 class="left_mideleton_h1">Loa Nghe Trong Nhà </h1>
            <p class="left_mideleton_p">Mang âm thanh đặc trưng của Marshall đi khắp mọi nơi bằng loa di động và giữ cho âm nhạc của bạn tiếp tục hàng giờ liền.</p>
            <button class="left_mideleton_button">Xem Thêm <i class="fa-solid fa-chevron-right"></i></button>
          </div>
        </div>
        <div class="bottom-marshall-house">
          <ul class="list-marshall">
            <li class="item">
              <div class="status">
                <div class="sale bg-dark text-white px-2 rounded-3 ">-19%</div>
                <div class="hot bg-danger mt-1  text-white px-2 rounded-3 ">Hot</div>
                <div class="new bg-success mt-1  text-white px-2 rounded-3 ">New</div>
              </div>
              <div class="action">
                  <p title="compare" class="compare"><i class="fa-solid fa-code-compare"></i></p>
                  <p title="Quick View" class="search"><i class="fa-solid fa-magnifying-glass"></i></p>
                  <p title="add to wishlish" class="wishlish"><i class="fa-regular fa-heart"></i></p>
              </div>
              <div class="img-product">
                <img loading="lazy" src="img/Marshall-Major4.png"  alt="" />
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
                <br>
                <span class="stock">In stock</span>
                <div class="price">
                  <p class="cost">3.690.000 ₫</p>
                  <p class="price">2.990.000 ₫</p>
                </div>
                <div class="color"></div>
                <a class="w-100 overflow-hidden ">
                  <p>Mua</p>
                  <i class="fa-solid fa-cart-shopping"></i>
                </a>
              </div>
            </li>
           
            <!--  -->
            <li class="item">
              <div class="status">
                <div class="sale bg-dark text-white px-2 rounded-3 ">-19%</div>
                <div class="hot bg-danger mt-1  text-white px-2 rounded-3 ">Hot</div>
                <div class="new bg-success mt-1  text-white px-2 rounded-3 ">New</div>
              </div>
              <div class="action">
                  <p title="compare" class="compare"><i class="fa-solid fa-code-compare"></i></p>
                  <p title="Quick View" class="search"><i class="fa-solid fa-magnifying-glass"></i></p>
                  <p title="add to wishlish" class="wishlish"><i class="fa-regular fa-heart"></i></p>
              </div>
              <div class="img-product">
                <img loading="lazy" src="img/marshall-stanmore-iii-black-01.webp"  alt="" />
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
                <br>
                <span class="stock">In stock</span>
                <div class="price">
                  <p class="cost">3.690.000 ₫</p>
                  <p class="price">2.990.000 ₫</p>
                </div>
                <div class="color"></div>
                <a class="w-100 overflow-hidden ">
                  <p>Mua</p>
                  <i class="fa-solid fa-cart-shopping"></i>
                </a>
              </div>
            </li>
            <!--  -->
            <li class="item">
              <div class="status">
                <div class="sale bg-dark text-white px-2 rounded-3 ">-19%</div>
                <div class="hot bg-danger mt-1  text-white px-2 rounded-3 ">Hot</div>
                <div class="new bg-success mt-1  text-white px-2 rounded-3 ">New</div>
              </div>
              <div class="action">
                  <p title="compare" class="compare"><i class="fa-solid fa-code-compare"></i></p>
                  <p title="Quick View" class="search"><i class="fa-solid fa-magnifying-glass"></i></p>
                  <p title="add to wishlish" class="wishlish"><i class="fa-regular fa-heart"></i></p>
              </div>
              <div class="img-product">
                <img loading="lazy" src="img/marshall-woburn-iii-black-01.webp"  alt="" />
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
                <br>
                <span class="stock">In stock</span>
                <div class="price">
                  <p class="cost">3.690.000 ₫</p>
                  <p class="price">2.990.000 ₫</p>
                </div>
                <div class="color"></div>
                <a class="w-100 overflow-hidden ">
                  <p>Mua</p>
                  <i class="fa-solid fa-cart-shopping"></i>
                </a>
              </div>
            </li>
            <!--  -->
            <li class="item">
              <div class="status">
                <div class="sale bg-dark text-white px-2 rounded-3 ">-19%</div>
                <div class="hot bg-danger mt-1  text-white px-2 rounded-3 ">Hot</div>
                <div class="new bg-success mt-1  text-white px-2 rounded-3 ">New</div>
              </div>
              <div class="action">
                  <p title="compare" class="compare"><i class="fa-solid fa-code-compare"></i></p>
                  <p title="Quick View" class="search"><i class="fa-solid fa-magnifying-glass"></i></p>
                  <p title="add to wishlish" class="wishlish"><i class="fa-regular fa-heart"></i></p>
              </div>
              <div class="img-product">
                <img loading="lazy" src="img/marshall-woburn-iii-cream-02.webp"  alt="" />
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
                <br>
                <span class="stock">In stock</span>
                <div class="price">
                  <p class="cost">3.690.000 ₫</p>
                  <p class="price">2.990.000 ₫</p>
                </div>
                <div class="color"></div>
                <a class="w-100 overflow-hidden ">
                  <p>Mua</p>
                  <i class="fa-solid fa-cart-shopping"></i>
                </a>
              </div>
            </li>
          </ul>
        </div>
      </div>
    </section>
</body>
<script type="text/javascript" src="js/main.js"></script>


</script>
</html>