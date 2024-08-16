/**
 * 
 */
const detail1 = document.querySelector(".detail1");
const left_mideleton_h1= document.querySelector(".left_mideleton_h1")
const left_mideleton_p= document.querySelector(".left_mideleton_p")
const left_mideleton_button= document.querySelector(".left_mideleton_button")
const content_marshall_house = document.querySelector(".content-marshall-house")
const img_marshall_house = document.querySelector(".img-marshall-house")
window.addEventListener("scroll",()=>{
    const ScrollThreshold = 550; // Khoảng cách kích hoạt hành động
    var currentScroll = window.pageYOffset || document.documentElement.scrollTop // Lấy vị trí của thanh cuộn
    if(detail1.offsetTop - currentScroll <= ScrollThreshold){
        detail1.classList.add("toggle")
        left_mideleton_h1.classList.add("toggle")
        left_mideleton_p.classList.add("toggle")
        left_mideleton_button.classList.add("toggle")
    }
    
    if(content_marshall_house.offsetTop -currentScroll <= ScrollThreshold){
         content_marshall_house.classList.add("toggle")
         img_marshall_house.classList.add("toggle")
    }
})