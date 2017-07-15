/**
 * Created by Simona on 7/15/2017.
 */
app.controller('ordersController', OrdersControllerFn);

OrdersControllerFn.$inject = ['ordersService'];

function OrdersControllerFn(ordersService) {
    var vm = this;

    vm.checkouts = [];
    vm.checkout = {};
}