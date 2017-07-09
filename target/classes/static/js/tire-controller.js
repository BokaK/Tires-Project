app.controller('tireController', TireControllerFn);

TireControllerFn.$inject = ['tireService','tireImageService','$http','brandService', 'seasonTypeService','vehicleTypeService', 'widthService', 'heightService', 'inchesService'];

function TireControllerFn(tireService, tireImageService, $http, brandService, seasonTypeService, vehicleTypeService, widthService, heightService, inchesService) {
    var vm = this;

    vm.save = save;
    vm.clear = clear;
    vm.edit = edit;
    vm.remove = remove;
    vm.entity = {};
    vm.entities = [];
    vm.possibleBrands=[];
    vm.seasonTypes=[];
    vm.vehicleTypes=[];
    vm.widths = [];
    vm.heights = [];
    vm.inches = [];
    vm.images =[];

    loadTires();
    loadBrands();
    loadSeasonTypes();
    loadVehicleTypes();
    loadWidths();
    loadHeights();
    loadInches();

    function loadTires() {
        tireService.getAll().then(function (data) {
            vm.entities = data;
        });
    }

    function loadSeasonTypes() {
        seasonTypeService.getAll().then(function (data) {
            vm.seasonTypes = data;
        });
    }

    function loadVehicleTypes() {
        vehicleTypeService.getAll().then(function (data) {
            vm.vehicleTypes = data;
        });
    }

    function loadBrands() {
        brandService.getAll().then(function (data) {
            vm.possibleBrands = data;
        });
    }

    function loadWidths() {
        widthService.getAll().then(function (data) {
            vm.widths = data;
        });
    }

    function loadHeights() {
        heightService.getAll().then(function (data) {
            vm.heights = data;
        });
    }

    function loadInches() {
        inchesService.getAll().then(function (data) {
            vm.inches = data;
        });
    }

    function  loadImages() {
        tireImageService.getAll().then(function (data) {
           vm.images = data;
        });
    }

    function save() {
        if (vm.entity.onSale == false)
        {
            vm.entity.priceOnSale = 0;
        }
        if (vm.entity.onStock == false)
        {
            vm.entity.stockNumber = 0;
        }
        var promise = tireService.save(vm.entity);
        promise.then(successCallback, errorCallback);
        function successCallback(object) {
            var  file  = document.getElementById('file').files[0];
            if(file != undefined)
            {
                var formData=new FormData();
                formData.append("file",file);
                formData.append("tire", object.data.id);
                $http({
                    method: 'POST',
                    url:  '/admin/tireImage/',
                    headers: { 'Content-Type': undefined},
                    data:  formData
                }).success(function(data, status) {
                    //alert("Success ... " + status);
                }).error(function(data, status) {
                    // alert("Error ... " + status);
                });
            }
            clear();
            loadTires();
        }
        loadTires();
        function errorCallback(data) {
        }
    }

    function clear() {

        var  checkbox  = document.getElementById('name2');
        checkbox.disabled = true;
        var  checkbox2  = document.getElementById('name1');
        checkbox2.disabled = true;
        vm.entity = {};

    }

    function edit(entity) {
        if (entity.onSale == true)
        {
            var checkbox = document.getElementById('name2');
            checkbox.disabled=false;
        }
        if (entity.onStock == true)
        {
            var checkbox2 = document.getElementById('name1');
            checkbox2.disabled = false;
        }
        vm.entity = {};
        angular.extend(vm.entity, entity);
    }

    function remove(entity) {
      tireService
            .remove(entity)
            .then(function () {
                loadTires();
                loadBrands();
                loadSeasonTypes();
                loadVehicleTypes();
                loadWidths();
                loadHeights();
                loadInches();
            });
    }

}
