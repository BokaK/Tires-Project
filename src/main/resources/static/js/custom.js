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


// Get the modal
var modal = document.getElementById('myModal2');
//For the second image
var img = document.getElementById('myImg2');
var modalImg = document.getElementById("img02");
var captionText = document.getElementById("caption2");
img.onclick = function(){
    modal.style.display = "block";
};

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close2")[0];

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
    modal.style.display = "none";
    $('#tires')[0].scrollIntoView(true);
};

});

$(document).keydown(function(event) {
    if (event.keyCode == 27) {
        $("#myModal2").hide();
        if ($('#li-tires').hasClass('active') == true)
        {
            $('#tires')[0].scrollIntoView(true);
        }
        else
        {
            $('#page-top')[0].scrollIntoView(true);
        }


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


/*Contact form */
$(document).ready(function() {
    $('#contact_form').bootstrapValidator({
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            first_name: {
                validators: {
                    stringLength: {
                        min: 2,
                        message: 'Внесете го вашето име!'
                    },
                    notEmpty: {
                        message: 'Внесете го вашето име!'
                    }
                }
            },
            last_name: {
                validators: {
                    stringLength: {
                        min: 2,
                        message: 'Внесете го вашето презиме!'
                    },
                    notEmpty: {
                        message: 'Внесете го вашето презиме!'
                    }
                }
            },
            email: {
                validators: {
                    notEmpty: {
                        message: 'Внесете ја вашата e-mail адреса!'
                    },
                    emailAddress: {
                        message: 'Внесете валидна e-mail адреса!'
                    }
                }
            },
            phone: {
                validators: {
                    notEmpty: {
                        message: 'Внесете го вашиот телефонски број!'
                    },
                    regexp: {
                        regexp: '^[0-9][0-9][0-9]-[0-9][0-9][0-9]-[0-9][0-9][0-9]$',
                        message: 'Внесете го вашиот телефонски број во следниот формат: 999-999-999!'
                    }
                }
            },
            address: {
                validators: {
                    stringLength: {
                        min: 8,
                        message: 'Задолжителна е вашата адреса!'
                    },
                    notEmpty: {
                        message: 'Задолжителна е вашата адреса!'
                    }
                }
            },
            city: {
                validators: {
                    stringLength: {
                        min: 4,
                        message: 'Задолжителна е вашата адреса!'
                    },
                    notEmpty: {
                        message: 'Внесете го вашиот град!'
                    }
                }
            }
        }
    })

});

