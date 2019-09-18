$(document).ready(function () {
 $(".formulario").css({'display': 'none'});
 // Menu Responsive
 $(".boton-menu img").click(function (e) {
  e.preventDefault();
  if ($(".boton-menu img").attr('class') === 'icon icon-menu') {
   $(".boton-menu img").removeClass('icon icon-menu').addClass('icon icon-cancel');
   $(".navegacion nav").animate({left: '0'})
   $(".contenido").animate({'margin-left': '14%'});
  } else {
   $(".boton-menu img").removeClass('icon icon-cancel').addClass('icon icon-menu');
   $(".navegacion nav").animate({'left': '-13%'})
   $(".contenido").animate({'margin-left': '0%'});
  }
 });
//Modal
 $(".modal-content div").click(function (e) {
  if ($(".modal-content div").attr('class') === 'modal-header prueba') {
   $(".modal-content div").removeClass('prueba').addClass('cancel');
   $(".modal").animate({'margin-top': '18%'});
  } else {
   $(".modal-content div").removeClass('cancel').addClass('prueba');
   $(".modal").animate({'margin-top': '0%'});
  }
 });

 $(".seleccionar").click(function (e) {
  $(".modal-content div").removeClass('cancel').addClass('prueba');
  $(".modal").animate({'margin-top': '0%'});
 });
 // Menu Responsive
// $(".navegacion nav").hover(function (e) {
//  e.preventDefault();
//  if ($(".boton-menu img").attr('class') === 'icon icon-menu') {
//   $(".boton-menu img").removeClass('icon icon-menu').addClass('icon icon-cancel');
//   $(".navegacion nav").animate({left: '0'});
//   $(".contenido").animate({'margin-left': '21%'});
//  } else {
//   $(".boton-menu img").removeClass('icon icon-cancel').addClass('icon icon-menu');
//   $(".navegacion nav").animate({left: '-20%'});
//   $(".contenido").animate({'margin-left': '0%'});
//  }
// });

// // Menu Fixed
// var navTop = $('.navegacion').offset().top;
// var navHeight = $('.navegacion').height();
//
// $(window).scroll(function () {
//  console.log($(window).scrollTop());
//  if ($(window).scrollTop() > navTop) {
//   $('.navegacion').css({'position': 'fixed', 'top': '0'})
//   $('body').css({'padding-top': navHeight})
//   $('.nav-responsive').css({'position': 'fixed'})
//  } else {
//   $('.navegacion').css({'position': '', 'top': ''})
//   $('body').css({'padding-top': '0'})
//   $('.nav-responsive').css({'position': 'absolute'})
//  }
// });
});