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
        $(".ddl-width, .ddl-height, .ddl-inch, .navbar").hide();
        modal.style.display = "block";
    };

// Get the <span> element that closes the modal
    var span = document.getElementsByClassName("close2")[0];

// When the user clicks on <span> (x), close the modal
    span.onclick = function() {
        modal.style.display = "none";
        $('#tires')[0].scrollIntoView(true);
        $(".ddl-width, .ddl-height, .ddl-inch, .navbar").show();
    };

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
                    }
                }
            },
            email: {
                validators: {
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
                        regexp: '^\+[0-9]+$',
                        message: 'Внесете го вашиот телефонски број во следниот формат: +38975123123!'
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
    }).on('error.field.bv', function(e, data) {
        $('#btnSaveUser').attr('disabled',true);
    }).on('success.field.bv', function(e, data) {
        if(data.bv.getInvalidFields().length ==0){
            $('#btnSaveUser').attr('disabled',false);
        }
    });
});


$('#quantity').focusin(function(){
    $(this).data('oldValue', $(this).val());
});

function animacija() {
    $('html,body').animate({
            scrollTop: $(".help-section").offset().top},
        1500, 'easeInOutExpo');
};

function showExtra() {
    $('#btnCancel').hide();
    $('#btnOrder').hide();
    $('#narackaCena').hide();
    $('#btnOk').show();

    $('#narackaCena, #textNaracka').hide();
    $('#uspesnaNaracka').fadeIn(3000);
};
function pom() {

    $('#btnCancel').show();
    $('#btnOrder').show();
    $('#narackaCena').show();
    $('#btnOk').hide();

    $('#narackaCena, #textNaracka').show();
    $('#uspesnaNaracka').hide();
};




function kosnicka (element) {
    var cart = $('.shopping-cart');
    var imgtodrag = $(element).parents('.item').find('img').eq(0);

    if (imgtodrag) {
        var nav = $('.navbar');
        nav.css({'z-index':'-1'});
        var imgclone = imgtodrag.clone()
            .offset({
                top: imgtodrag.offset().top,
                left: imgtodrag.offset().left
            })
            .css({
                'opacity': '0.5',
                'position': 'absolute',
                'height': '150px',
                'width': '150px',
                'z-index': '100'
            })
            .appendTo($('body'))
            .animate({
                'top': cart.offset().top + 10,
                'left': cart.offset().left + 10,
                'width': 75,
                'height': 75
            }, 1000, 'easeInOutExpo');


        imgclone.animate({
            'width': 0,
            'height': 0
        }, function () {
            $(this).detach()
        });
    }
    nav.css({'z-index':'1'});

};
function btnClick() {
    console.log("Vleguva");
  $('#btnSaveUser').click();
};