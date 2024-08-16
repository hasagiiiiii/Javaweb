/**
 * 
 */
let curentLocation = window.location.href;
    let Location = curentLocation.split("/").pop().split(".").shift();
    $("#url").text(`/${Location}`);

    let priceGarp = 100;
    var InputRange = $("[type=range]");
    var priceStart =$(".price-start")
    var priceStop =$(".price-stop")
    priceStart.text(parseInt(InputRange.eq(0).attr('min')).toFixed(3))
    priceStop.text(parseInt(InputRange.eq(0).attr('max')).toFixed(3))
    InputRange.each((index, input) => {
      $(input).on("input", (e) => {
        let minValue = parseInt(InputRange.eq(0).val()), // lấy giá trị nhỏ nhất
          maxValue = parseInt(InputRange.eq(1).val()); 
          console.log(minValue,maxValue) // lấy giá trị lớn nhất
        if (maxValue - minValue < priceGarp) {  // xem khoảng cách giữa 2 giá trị có trong khoảng cho phép ko
          if ($(e.target).hasClass("range-min")) {
            InputRange.eq(0).val(maxValue - priceGarp); // set value cho thanh kéo đầu luôn trong khoảng cách cho phép
            priceStart.text(min)
            
          } else {
            InputRange.eq(1).val(minValue + priceGarp); // set value cho thanh kéo cuối luôn trong khoảng cách cho phép
            priceStop.text(max)

          }
        } else {
        	$(".progress-before").css(`left`,`${(minValue / parseInt(InputRange.eq(0).attr("max"))) * 100}%`);
        	$(".progress-before").css(`right`,`${100 - (maxValue / parseInt(InputRange.eq(1).attr("max"))) * 100}%`);

        	// Giải quyết phần biểu thức EL thành JavaScript và gán giá trị
        	var min = (minValue / parseInt(InputRange.eq(0).attr("max"))) * 1000;
        	var max = (maxValue / parseInt(InputRange.eq(1).attr("max"))) * 1000;
        	priceStart.text(min.toFixed(3));
        	priceStop.text(max.toFixed(3));
      }});
    }
    );