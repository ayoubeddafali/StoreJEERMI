$("#home_nav").click(function () {
    $(this).addClass("active");
    $("#login_nav").removeClass("active");
    $("#signup_nav").removeClass("active");

    $("#main").removeClass("get_out").addClass("animated fadeIn");
    $("#login").addClass("get_out");
    $("#signup").addClass("get_out");
});
$("#login_nav").click(function () {
    $(this).addClass("active");
    $("#home_nav").removeClass("active");
    $("#signup_nav").removeClass("active");

    $("#login").removeClass("get_out").addClass("animated fadeIn");
    $("#main").addClass("get_out");
    $("#signup").addClass("get_out");
});

$("#signup_nav").click(function () {
    $(this).addClass("active");
    $("#login_nav").removeClass("active");
    $("#home_nav").removeClass("active");

    $("#signup").removeClass("get_out").addClass("animated fadeIn");
    $("#main").addClass("get_out");
    $("#login").addClass("get_out");
});
