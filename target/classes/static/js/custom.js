/**
 * Created by user on 07.7.2017.
 */
// jQuery to collapse the navbar on scroll
function collapseNavbar() {
    if ($(".navbar").offset().top > 50) {
        $(".navbar-fixed-top").addClass("top-nav-collapse");
    } else {
        $(".navbar-fixed-top").removeClass("top-nav-collapse");
    }
}

$(window).scroll(collapseNavbar);
$(document).ready(collapseNavbar);

// jQuery for page scrolling feature
$(function() {
    $('a.page-scroll').bind('click', function(event) {
        var $anchor = $(this);
        $('html, body').stop().animate({
            scrollTop: $($anchor.attr('href')).offset().top
        }, 1500, 'easeInOutExpo');
        event.preventDefault();
    });
});
$('.navbar-collapse ul li a').click(function() {
    $(".navbar-collapse").collapse('hide');
});

$(function () {


// Get the modal
var modal = document.getElementById('myModal');

// Get the image and insert it inside the modal - use its "alt" text as a caption
var img = document.getElementById('myImg');
var modalImg = document.getElementById("img01");
var captionText = document.getElementById("caption");
img.onclick = function(){
    modal.style.display = "block";
   // modalImg.src = "../images/measures1.jpg";
    // captionText.innerHTML = this.alt;
};

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
    modal.style.display = "none";
};

});

$(document).keydown(function(event) {
    if (event.keyCode == 27) {
        $("#myModal").hide();

    }
});
$(function () {
   var pageTop = document.getElementById("btn-pageTop");
   pageTop.onclick = function () {
       $("select").val([]);
   };
});

$(window).load(function() {
    // Animate loader off screen
    $(".se-pre-con").fadeOut("slow");
});

$("#unselectBrand").click(function(){
    $('.ddl-brand').val([]);

});
$("#unselectHeight").click(function(){
    $('.ddl-height').val([]);

});
$("#unselectSeasonType").click(function(){
    $('#ddl-seasonType').val([]);

});
$("#unselectWidth").click(function(){
    $('.ddl-width').val([]);

});
$("#unselectInch").click(function(){
    $('.ddl-inch').val([]);

});