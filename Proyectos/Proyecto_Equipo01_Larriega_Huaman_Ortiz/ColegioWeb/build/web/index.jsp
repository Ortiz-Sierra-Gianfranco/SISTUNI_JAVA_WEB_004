<%-- 
    Document   : index
    Created on : 11/08/2016, 12:22:00 PM
    Author     : USUARIO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>COLEGIO</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <link href='https://fonts.googleapis.com/css?family=Titillium+Web:400,600' rel='stylesheet' type='text/css'>
    </head>
    <body>
        <div><jsp:include page="menuPrincipal.jsp"/></div>
        <div class="container">
        <table>
            <tr><h1 class="colegio-titulo">London High School</h1></tr>
            <tr><hr class="border"></tr>
            <tr>
                <td class="img-padding">
                    <div class="img0">
                    <img class="mySlides" src="img/img01.jpg">
                    <img class="mySlides" src="img/img02.jpg">
                    <img class="mySlides" src="img/img03.jpg">
                    <img class="mySlides" src="img/img04.jpg">
                    </div>
                </td>
                <td class="formulario01">
                    <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Donec odio. Quisque volutpat mattis eros. Nullam malesuada erat ut turpis. Suspendisse urna nibh, viverra non, semper suscipit, posuere a, pede.</p>
                    <br>
                    <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Donec odio. Quisque volutpat mattis eros. Nullam malesuada erat ut turpis. Suspendisse urna nibh, viverra non, semper suscipit, posuere a, pede.</p>
                    <br>
                    <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Donec odio. Quisque volutpat mattis eros. Nullam malesuada erat ut turpis. Suspendisse urna nibh, viverra non, semper suscipit, posuere a, pede.</p>
                    <br>
                    <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Donec odio. Quisque volutpat mattis eros. Nullam malesuada erat ut turpis. Suspendisse urna nibh, viverra non, semper suscipit, posuere a, pede.</p>
                    
                </td>
            </tr>
        </table>
        </div>
        <script>
            var slideIndex = 0;
            carousel();

           function carousel() {
            var i;
            var x = document.getElementsByClassName("mySlides");
            for (i = 0; i < x.length; i++) {
                x[i].style.display = "none"; 
            }
            slideIndex++;
            if (slideIndex > x.length) {slideIndex = 1} 
            x[slideIndex-1].style.display = "block"; 
            setTimeout(carousel, 2000);
}
        </script>
    </body>
</html>
