/**
 * Created by Simona on 7/15/2017.
 */
app.controller('ordersController', OrdersControllerFn);

OrdersControllerFn.$inject = ['ordersService'];

function OrdersControllerFn(ordersService) {
    var vm = this;

    vm.checkouts = [];
    vm.checkout = {};
    vm.cartItems = [];

    vm.remove = remove;


    loadCheckouts();

    function loadCheckouts() {
        ordersService.getAll().then(function (data) {
           vm.checkouts = data;
           for(var $i in vm.checkouts){
               ordersService.getCartItems(vm.checkouts[$i].cart.id).then(function (data) {
                   for(var $j in data) {
                       vm.cartItems.push(data[$j]);
                   }

               });
           }
        });
    }


    function remove(entity) {
        ordersService
            .remove(entity)
            .then(function () {
                loadCheckouts();
            });
    }
}