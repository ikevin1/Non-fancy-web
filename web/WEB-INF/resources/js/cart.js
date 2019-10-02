// JavaScript Document
var app = angular.module('iSupport', ['ui.bootstrap', 'ngRoute', 'ngMaterial', 'ngMessages']);


app.run(function ($rootScope, $location) {
    var d = new Date();
    $rootScope.appName = 'iSupport';
    $rootScope.copyright = d.getFullYear();

    $rootScope.isActive = function (viewLocation){
        return viewLocation === $location.path();
    };
});
//configure our routes
//matching a URL to a controller/view
app.config(function ($locationProvider, $routeProvider) {
    $locationProvider.html5Mode({
        enabled:true,
        requireBase: false
    });
    $routeProvider

        .when('/', {
            templateUrl: 'index.htm',
            controller: 'itemController'
        })
        .when('/product', {
            templateUrl: 'product.htm',
            controller: 'itemController'
        })
        .when('/contact', {
            templateUrl: 'summary.htm',
            controller: 'itemController'
        })
        .when('/about', {
            templateUrl: 'about.htm>',
            controller: 'itemController'
        });
});

app.config(function($mdThemingProvider) {

    // Configure a dark theme with primary foreground yellow

    $mdThemingProvider.theme('docs-dark', 'default')
        .primaryPalette('yellow')
        .dark();

});

app.controller('homeController', function ($scope){

});

// Products controller
app.controller('itemsController', function($scope, $window){
    $scope.myCart = [];
    // sample products
    // ideally, add image, rating, description, etc to this array
    $scope.items = [
        {"name":"Jo D' Magician", "description": "I have won 5 awards and needing help to get my 6th award", "price":50},
        {"name":"Hu D' Runner", "description": "This's my first tournament abroad to compete for 1500m race", "price":70},
        {"name":"Xi D' Salsa Dancer", "description": "I have dance and made the queen hit the flour dance", "price":35},
        {"name":"Paddy D' Commedian", "description": "Am the only commedian of my age who makes people 'LOL'", "price":25},
        {"name":"Lu D' Pilot", "description": "I need a special traning to fly the new militia pilot", "price":125}
    ];

    $scope.addItems = function(item) {
        $scope.items.push(item);
        $scope.item = {};

    };


    $scope.addToCart = function(item) {
        $scope.myCart.push(angular.copy(item));
        $scope.amount += item.price;
        //$scope.remove - item.amount;
        // $scope.myCart.remove(item, 1) - amount;
    };

    $scope.getTotalAmount = function() {
        var i = 0;
        for (i=0; i<$scope.myCart.length; i++) {
            // $scope.myCart.splice(item{i}, 1) - amount;
            // $scope.myCart.item.price{i} * $scope.myCart.item.price{i};
        }
    };

    $scope.amount = 0.00;
    // $scope.myCart.splice(item{i}, 1) - total;
    // add to cart
    //$scope.cart.push(items);

//onSelect(item: viewCart): void {
    //this.item = viewCart;
//}

    // $scope.remove = function(item) {
    //return$scope.items.push(item);
    //  $scope.removeItem = {};

    // };

    $scope.remove = function(item) {
        $scope.amount -= item.price;
        //$scope.myCart.splice(angular.remove(item));
        $scope.myCart.splice(item, 1);
        //$scope.myCart.splice(item.price - amount, 1);
        //$scope.items.splice(item, 1);
    };
// $scope.remove = function(item) {
    // if (item.quantity > 0) {
    //  item.quantity--;
    //  }
    //  };

    // $scope.sumCalc = function() {
    //  var amount = 0;
    // angular.forEach($scope.myCart.splice(item, 1) {
    // //  sum += parseInt(item.price,10);
    // });
    // return sum;
    //};

    var prod = {
        "preview": [
            {
                "Name": "Jo D' Magician",
                "Description": "I have won 5 awards and needing help to get my 6th award.  There are so many things in the magic world i need to learn to help me keep winning.",
                "image": "pictures/Jo.png",
            },
            {
                "Name": "Hu D' Runner",
                "Description": "This's my first tournament abroad to compete for 1500m race",
                "image": "pictures/Hu.png",
            },
            {
                "Name": "Xi D' Salsa Dancer",
                "Description": "I have dance and made the queen hit the flour dance",
                "image": "pictures/Xi.png",
            },
            {
                "Name": "Paddy D' Comedian",
                "Description": "Am the only comedian of my age who makes people 'LOL'",
                "image": "pictures/paddy.png",
            },
            {
                "Name": "Lu D' Pilot",
                "Description": "I need a special traning to fly the new militia pilot",
                "price":125,
                "image": "pictures/Lu.png",
            },
        ]
    };

//var app = angular.module('cart', []);

    $scope.products = prod.preview;

    $scope.checkout = function(){
        $scope.showForm = true;

    };



//var app = angular.module('demoController', ['ngMaterial', 'ngMessage'])
    $scope.user = {
        title: 'Name',
        email: 'you@school.com',
        firstName: '',
        lastName: '',
        company: '',
        address: '',
        city: '',
        state: 'WI',
        postalCode: '53000'
    };

    $scope.states = ('AL AK AZ AR CA CO CT DE FL GA HI ID IL IN IA KS KY LA ME MD MA MI MN MS ' +
        'MO MT NE NV NH NJ NM NY NC ND OH OK OR PA RI SC SD TN TX UT VT VA WA WV WI ' +
        'WY').split(' ').map(function(state) {
        return {abbrev: state};
    });
    $scope.clicked = function() {
        $window.alert("Thank you for your purchase");
    };

}); // end of items controller



//$scope('should check ngShow', function() {
//  var checkbox = element(by.model('checked', 'check'));
//    //var checkbox = element(by.model('check'));
//  var checkElem = element(by.css('.check-element'));
//
//  expect(checkElem.isDisplayed()).toBe(false);
//  checkbox.click();
//  expect(checkElem.isDisplayed()).toBe(true);
//    });
//});
//payment
//$scope.payment = function() {
//      var r = Math.ceil(Math.random() * 1000);
//      $scope.radioData.push({ label: r, value: r });
//    };



//$scope.payment = function (){

//		$scope.creditCardInfo.$add({creditCardNumber: $scope.newCreditCardNumber, nameOnCC: $scope.newCardHolderName, expireDate: $scope.newExpirationDate, cvv: $scope.newCVV});
//
//		$scope.showtimerCtrl();
//		$scope.next();
//		$scope.countdown();
//
//
//	};

//    //timer setup
//    app.controller("timerCtrl",['$scope','$timeout', function($scope,$timeout){
//    //if timer elapse, coupon expires
//     //initial counter value
//    var code = { code: ["buyNoW", "HaPpY"]};
//    var computer =code[Math.floor(Math.random() * code.length)];
//    $scope.counter = 20;
//    var stopped;
//    $scope.countdown = function() {
//        stopped = $timeout(function() {
//           console.log($scope.counter);
//         $scope.counter--;
//         $scope.countdown();
//        }, 500);
//        if($scope.counter <=0){
//            alert('Ooops!!! Expired!');
//            $scope.stop();
//        }
//      };
//
//    $scope.stop = function(){
//       $timeout.cancel(stopped);
//
//        };
//
//    }]);