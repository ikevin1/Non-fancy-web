<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html ng-app="iSupport">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>iSupport - About</title>
    <link rel="icon" type="image/png" href="WEB-INF/resources/img/hand.png">
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/angular_material/1.1.8/angular-material.min.css">
    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.7/angular.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.7/angular-animate.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.7/angular-route.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.7/angular-aria.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.7/angular-messages.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.1/moment.js"></script>
    <script src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/t-114/svg-assets-cache.js"></script>
    <script src="https://cdn.gitcdn.link/cdn/angular/bower-material/v1.1.10/angular-material.js"></script>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700,400italic">

    <script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.7.2/angular-touch.min.js"></script>
    <script src="vendor/ui-bootstrap/js/ui-bootstrap-tpls-3.0.4.min.js"></script>
    <!-- Custom styles  -->
    <link href="WEB-INF/resources/css/cart.css" rel="stylesheet">
    <!-- Custom JS code -->
    <script src="WEB-INF/resources/js/cart.js"></script>
</head>

<body ng-controller="itemsController">
<nav class="navbar navbar-expand-lg navbar-red bg-dark fixed-top">
    <div class="container"> <a class="navbar-brand" href="#">{{Cart}}</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation"> <span class="navbar-toggler-icon"></span> </button>

        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="nav nav-pills">
                <li class="nav-item" ng-class="{active: isActive('/')}"> <a class="nav-link" href="#/!">Home </a> </li>
                <li class="nav-item" ng-class="{active: isActive('/about')}"> <a class="nav-link" href="#!about">About</a> </li>
                <li class="nav-item" ng-class="{active: isActive('/product')}"> <a class="nav-link" href="#!product">Product </a> </li>
                <li class="nav-item" ng-class="{active: isActive('/summary')}"> <a class="nav-link" href="#summary">Summary <img ng-src="pictures/shop cart.png" aria-label="shop cart"></a> </li>
            </ul>
        </div>
    </div>
</nav>
<div ng-view></div>
<div id="searchBoxes">
    <h1>Search for your Actor details below</h1>
    Global Search Filter: <input type="text" ng-model="globalSearch.$"><br><br>
    Actor Name Search Filter: <input type="text" ng-model="globalSearch.Name"><br><br>
    Description Search Filter: <input type="text" ng-model="globalSearch.Description"><br><br>
    Price Search Filter: <input type="text" ng-model="globalSearch.Price"><br><br>

</div>
<md-divider></md-divider>
<div class="itemController" >
    <ul>

        <li ng-repeat="item in products | filter:globalSearch">
            Name: {{item.Name}} <br> Description: {{item.Description}} <br>  <br> Image: <a href><img class="photo" style="height:100px; width:80px;" alt="item image" ng-src="{{item.image}}"> </a> <br><br>
        </li>
    </ul>



</div>
</body>
<!-- Footer -->
<footer class="py-5 bg-dark">
    <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; {{Cart}} {{copyright}} Kevin.</p>
    </div>
</footer>


</html>