var myApp = angular.module("myApp1", []);

myApp.controller("myCtrl", function ($scope, $http){
	
	$scope.orderType = 'sell';
    $scope.orderDate = new Date();
	$scope.getMaxOrderNo = function(){
		$http({
            method: 'GET',
            url: 'maxOrderNo'
        }).then(function (response) {
            $scope.orderNo = response.data;
        });
	};
	 $scope.getMaxOrderNo();
	
	$scope.customers = [];
	$scope.getAllCustomer = function () {
        $http({
            method: 'GET',
            url: 'customers'
        }).then(function (response) {
            $scope.customers = response.data;
        });
    };
    //call getAllProduct method
    $scope.getAllCustomer();
    $scope.clickedCustomer = {};
    
    
    
    
    $scope.products = [];
    $scope.getAllProduct = function () {
        $http({
            method: 'GET',
            url: '/products'
        }).then(function (response) {
            $scope.products = response.data;
        });
    };
    //call getAllProduct method
    $scope.getAllProduct();

	$scope.qty = 0;
    $scope.total = 0;

    $scope.cartProduct = [];
    $scope.finalTotal = 0;
    $scope.addToCart = function () {

        $scope.cp = {};
        $scope.cp = $scope.clickedProduct;
        $scope.cp.cartqty = 1;
        $scope.cp.subTotal = $scope.cp.cartqty * $scope.cp.price;

        //$scope.cartProduct.push($scope.cp);

        if ($scope.cartProduct.length === 0) {
            $scope.cartProduct.push($scope.cp);
            $scope.finalTotal += $scope.cp.subTotal;
        } else {
            var i = 0;
            for (i = 0; i < $scope.cartProduct.length; i++) {

                if ($scope.cartProduct[i].id === $scope.cp.id) {
                    alert('Product Already exist');
                    break;
                }
            }
            if (i === $scope.cartProduct.length) {
                $scope.cartProduct.push($scope.cp);
                $scope.finalTotal += $scope.cp.subTotal;
            }
        }

    };

    $scope.removeCart = function (cp) {
        var i = 0;
        for (i = 0; i < $scope.cartProduct.length; i++) {

            if ($scope.cartProduct[i].id === $scope.cp.id) {

                $scope.cartProduct.splice(i, 1);
            }
        }
        $scope.finalTotal = $scope.finalTotal - cp.subTotal;



    }

    $scope.qtyINC = function (cp) {
        cp.cartqty++;
        subTotal1 = cp.price * cp.cartqty;
        $scope.finalTotal = $scope.finalTotal - cp.subTotal + subTotal1;
        cp.subTotal = subTotal1;
    }

  $scope.qtyDec = function (cp) {
        cp.cartqty--;
        subTotal1 = cp.price * cp.cartqty;
        $scope.finalTotal = $scope.finalTotal - cp.subTotal + subTotal1;
        cp.subTotal = subTotal1;
    }
});
