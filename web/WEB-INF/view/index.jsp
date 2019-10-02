<!DOCTYPE html>
<html ng-app="iSupport">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>iSupport</title>
    <link rel="icon" type="image/png" href="resources/img/hand.png">
    <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/angular_material/1.1.8/angular-material.min.css">
    <!-- Bootstrap core CSS -->
    <link href="resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
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
    <script src="resources/vendor/ui-bootstrap/js/ui-bootstrap-tpls-3.0.4.min.js"></script>
    <!-- Custom styles  -->
    <link href="resources/css/cart.css" rel="stylesheet">
    <!-- Custom JS code -->
    <script src="resources/js/cart.js"></script>
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
                <li class="nav-item" ng-class="{active: isActive('/summary')}"> <a class="nav-link" href="#summary">Summary <img ng-src="resources/img/shop cart.png" aria-label="shop cart"></a> </li>
            </ul>
        </div>
    </div>
</nav>
<div ng-view></div>
<!-- Page Content -->
<div id="containerr" style="padding-left: 500px; padding-bottom: 40px;">
    <img ng-src="resources/img/dis.jpg" style="height:190px; width:300px">
</div>
<div>
    <md-divider></md-divider>
</div>
<div class="container" style="float: right;">

    <h1>Help Support the Teen American talent</h1>
    <p> You can support as many times as possible, but each will meet the minimum specified.</p>
    <h1> Thanks for your support</h1>
    <div class="table-responsive">
        <table class="table table-striped table-bordered table-hover" border="2">
            <thead>
            <tr>
                <th>Actor</th>
                <th>Talent Description</th>
                <th>Donation Amount</th>
                <th>Action</th>

            </tr>
            </thead>

            <tbody>
            <!--                Table header-->
            <tr ng-repeat="item in items">
                <td>{{item.name}}</td>
                <td>{{item.description}}</td>
                <td>{{item.price | currency}}</td>
                <td><button ng-click="addToCart(item)">iSupport</button></td>

            </tr>
            </tbody>
        </table>
    </div>

    <div class="row">
        <div class="col-md-4">
            <div class="myCart">
                <div class="table">
                    <table class="table table-striped table-hover">
                        <thead>
                        <tr>
                            <!--                               Table shows summary of the donation chosen-->
                            <th>Name</th>
                            <th>Donation Amount</th>
                        </tr>
                        </thead>

                        <tbody>
                        <tr ng-repeat="item in myCart">
                            <td>{{item.name}}</td>
                            <td>{{item.price | currency}}</td>
                            <td><button ng-click="remove(item)">Remove</button></td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

    <div class="myAmount">
        Amount $<input style="margin-left:350px;" type="text" name="myAmount" ng-model="amount">
    </div>


</div>
<br>
<main style="float: left;">
    <!--  <md-divider></md-divider>-->
    <div class="offer">
        <img ng-src="resources/img/hand.png" style="height:70px; width:90px">
        <p id="hand">Give Extra Hand For Special Treat!</p>
        <p class="description">Don't miss out on this special offer!!!</p>
        <p> <img ng-src="resources/img/Lu.png" style="height:70px; width:90px"></p>
        <p>Support Lu D' Pilot three times to get amazing reward</p>

        <button ng-click="showme=true">Interested</button>
        <button ng-click="showme=false">Not Now</button>

        <div class="wrapper">
            <h2 ng-hide="showme">Sorry, you missed this special offer</h2>
            <h2 ng-show="showme">After we receieve your support, we will mail you a military pilot shirt and hat</h2>
        </div>

    </div>
    <br>

</main>

</body>
<!--Check out form-->

<br>


<!-- Footer -->

<footer class="py-5 bg-dark">
  <div class="container">
    <p class="m-0 text-center text-white">Copyright &copy; {{Cart}} {{copyright}} Kevin.</p>
  </div>
</footer>



</html>