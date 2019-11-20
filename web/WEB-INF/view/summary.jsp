<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html ng-app="iSupport">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>iSupport - Summary</title>
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
<!--Check out form-->

<div class="itemController" layout="column" ng-cloak class="md-inline-form">

    <md-content layout-gt-sm="row" layout-padding>
        <div layout-gt-sm="row">


            <!--<div class="myAmount">
           Amount<input style="margin-left:100px;" type="text" name="myAmount" ng-model="amount">
       </div>-->
            <div class="myAmount">
                <md-input-container class="md-block" flex-gt-sm>
                    Total Amount to Pay:$  <input type="text" placeholder="Amount Pledged"  name="myAmount" ng-model="amount">
                </md-input-container>
            </div>
        </div>
    </md-content>
    <!-- <md-button ng-click="checkout()" class="md-raised md-primary" type="submit">Checkout</md-button>-->

    <button ng-click="checkout()">Checkout</button>

    <md-content layout-padding ng-show="showForm">
        <div>
            <form name="userForm">



                <div layout-gt-sm="row">
                    <md-input-container class="md-block" flex-gt-sm>
                        <label>First name</label>
                        <input ng-model="user.firstName">
                    </md-input-container>

                    <md-input-container class="md-block" flex-gt-sm>
                        <label>Last Name</label>
                        <input ng-model="theMax">
                    </md-input-container>
                </div>

                <md-input-container class="md-block">
                    <label>Contact Address</label>
                    <input ng-model="user.address" placeholder="800 Main street">
                </md-input-container>

                <md-input-container md-no-float class="md-block">
                    <input ng-model="user.address2" placeholder="Address 2">
                </md-input-container>

                <div layout-gt-sm="row">
                    <md-input-container class="md-block" flex-gt-sm>
                        <label>City</label>
                        <input ng-model="user.city">
                    </md-input-container>

                    <md-input-container class="md-block" flex-gt-sm>
                        <label>State</label>
                        <md-select ng-model="user.state">
                            <md-option ng-repeat="state in states" value="{{state.abbrev}}">
                                {{state.abbrev}}
                            </md-option>
                        </md-select>
                    </md-input-container>

                    <md-input-container class="md-block">
                        <label>Postal Code</label>
                        <input name="postalCode" ng-model="user.postalCode" placeholder="12345"
                               required ng-pattern="/^[0-9]{5}$/" md-maxlength="5">

                        <div ng-messages="userForm.postalCode.$error" role="alert" multiple>
                            <div ng-message="required" class="my-message">You must supply a 5 digit postal code.</div>
                            <div ng-message="pattern" class="my-message">That doesn't look like a valid postal code.
                            </div>
                            <div ng-message="md-maxlength" class="my-message">
                                Don't use the long version ...don't need to be that specific...
                            </div>
                        </div>
                    </md-input-container>
                </div>
                <br>
                <br>
                <md-divider></md-divider>
                <br>
                <div class="payment" layout="column" ng-cloak class="md-inline-form">
                    <div layout-gt-sm="row">

                        <md-input-container class="md-block">
                            <caption>Is the billing information same as the shipping information? </caption>

                            <div>
                                <!--  Yes: <input type="checkbox"  ng-model="checked" value="yes" aria-label="Toggle ngShow"><br />

           -->
                                <md-radio-group ng-model="checked">
                                    <md-radio-button value="Yes"> Yes </md-radio-button>
                                    <md-radio-button value="No">No</md-radio-button>
                                </md-radio-group>

                                <!--
                                             <div>
                                                    No: <input type="checkbox" value="no" ng-model="checked" aria-label="Toggle ngShow"><br />
                                                  </div>
                                                 </md-input-container>
                                -->
                                <div class="check-elements animate-show-hide" ng-show="checked == 'Yes'">
                                    Okay! proceed to payment
                                </div>

                                <div class="check-element animate-show-hide" ng-show="checked == 'No'">



                                    <div layout-gt-sm="row">
                                        <md-input-container class="md-block" flex-gt-sm>
                                            <label>First name on Card</label>
                                            <input ng-model="user.firstNamee">
                                        </md-input-container>

                                        <md-input-container class="md-block" flex-gt-sm>
                                            <label>Last Name on Card</label>
                                            <input ng-model="theMaxx">
                                        </md-input-container>
                                    </div>

                                    <md-input-container class="md-block">
                                        <label>Address on Card</label>
                                        <input ng-model="user.addresss" placeholder="800 Main street">
                                    </md-input-container>

                                    <md-input-container md-no-float class="md-block">
                                        <input ng-model="user.addresss2" placeholder="Address 2">
                                    </md-input-container>

                                    <div layout-gt-sm="row">
                                        <md-input-container class="md-block" flex-gt-sm>
                                            <label>City (Must match)</label>
                                            <input ng-model="user.cityy">
                                        </md-input-container>

                                        <md-input-container class="md-block" flex-gt-sm>
                                            <label>State</label>
                                            <md-select ng-model="user.statee">
                                                <md-option ng-repeat="state in states" value="{{state.abbrev}}">
                                                    {{state.abbrev}}
                                                </md-option>
                                            </md-select>
                                        </md-input-container>

                                        <md-input-container class="md-block" flex-gt-sm>
                                            <label>Postal Code</label>
                                            <input name="postalCode" ng-model="user.postalCode" placeholder="12345"
                                                   required ng-pattern="/^[0-9]{5}$/" md-maxlength="5">

                                            <div ng-messages="userForm.postalCode.$error" role="alert" multiple>
                                                <div ng-message="required" class="my-message">You must supply a 5 digit postal code.</div>
                                                <div ng-message="pattern" class="my-message">That doesn't look like a valid postal code.
                                                </div>
                                                <div ng-message="md-maxlength" class="my-message">
                                                    Don't use the long version ...don't need to be that specific...
                                                </div>
                                            </div>
                                        </md-input-container>
                                    </div>
                                </div>
                            </div>

                        </md-input-container>
                    </div>
                    <br>
                    <md-divider></md-divider>

                    <md-input-container class="md-block" flex-gt-sm>
                        <label>Card Number</label>
                        <input ng-model="payment.card" value="cardNumber" placeholder="Your card number"
                               required ng-pattern="/^[0-9]{16}$/" md-maxlength="16">
                    </md-input-container>
                    <div layout-gt-sm="row">
                        <md-input-container class="md-block" flex-gt-sm>
                            <label>Expiry Date</label>
                            <input ng-model="payment.cards" value="expiryDate" placeholder="12/18"
                                   required ng-pattern="/^[0-9]{5}$/" md-maxlength="5">
                        </md-input-container>


                        <md-input-container class="md-block" flex-gt-sm>
                            <label>CVV</label>
                            <input ng-model="payment.cardd" value="cvv" placeholder="XXX"
                                   required ng-pattern="/^[0-9]{3}$/" md-maxlength="3">
                        </md-input-container><br></div>
                </div>
                <md-button class="md-raised md-primary" ng-click="clicked()" type="submit">Click To Pay</md-button>


            </form>
        </div>

    </md-content>

</div>
</body>

<!-- Footer -->
<footer class="py-5 bg-dark">
    <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; {{Cart}} {{copyright}} Kevin.</p>
    </div>
</footer>


</html>