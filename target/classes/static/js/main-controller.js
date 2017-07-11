/**
 * Created by user on 08.7.2017.
 */
app.controller('mainController', MainControllerFn);

MainControllerFn.$inject = ['mainService'];

function MainControllerFn(mainService) {
    var vm = this;

    vm.entity = {};
    vm.entities = [];
    // All kinds of season type
    vm.seasonTypes = [];
    // Selected value from the dropdown list
    vm.selectedSeasonType = "";
    vm.brands = [];
    vm.selectedBrand = "";
    vm.heights = [];
    vm.selectedHeight = "";
    vm.widths = [];
    vm.selectedWidth = "";
    vm.inches = [];
    vm.selectedInch = "";
    vm.filterFunction = filterFunction;
    vm.filterInches = filterInches;
    vm.filterHeights = filterHeights;
    vm.filterWidths = filterWidths;


    loadTires();
    loadBrands();
    loadSeasonTypes();
    loadWidths();
    loadHeights();
    loadInches();

    function loadTires() {
        mainService.getAllTires().then(function (data) {
            vm.entities = data;
        });
    }
    function loadSeasonTypes() {
        mainService.getAllSeasonTypes().then(function (data) {
            vm.seasonTypes = data;
        });
    }
    function loadBrands() {
        mainService.getAllBrands().then(function (data) {
            vm.brands = data;
        });
    }
    function loadWidths() {
        mainService.getAllWidths().then(function (data) {
            vm.widths = data;
        });
    }
    function loadHeights() {
        mainService.getAllHeights().then(function (data) {
            vm.heights = data;
        });
    }
    function loadInches() {
        mainService.getAllInches().then(function (data) {
            vm.inches = data;
        });
    }

    function filterFunction(element) {
        if (vm.selectedBrand == "" && vm.selectedSeasonType == "" && vm.selectedInch == "" && vm.selectedHeight == "" && vm.selectedWidth == "")
        {
            return true;
        }
        else if (vm.selectedBrand != "")
        {
            if (vm.selectedSeasonType != "")
            {
                if (vm.selectedInch != "" )
                {
                    if (vm.selectedHeight != "")
                    {
                        if (vm.selectedWidth != "")
                        {
                            if (element.width.width == vm.selectedWidth.width && element.height.height == vm.selectedHeight.height
                                && element.inches.inches == vm.selectedInch.inches && element.brandName.brandName == vm.selectedBrand.brandName && element.seasonType.seasonType == vm.selectedSeasonType.seasonType)
                                return true;
                            else return false;
                        }
                        else
                        {
                            if (element.height.height == vm.selectedHeight.height && element.inches.inches == vm.selectedInch.inches && element.brandName.brandName == vm.selectedBrand.brandName && element.seasonType.seasonType == vm.selectedSeasonType.seasonType)
                                return true;
                            else return false;
                        }
                    }
                    else
                    {
                        if (vm.selectedWidth != "")
                        {
                            if (element.width.width == vm.selectedWidth.width
                                && element.inches.inches == vm.selectedInch.inches && element.brandName.brandName == vm.selectedBrand.brandName && element.seasonType.seasonType == vm.selectedSeasonType.seasonType)
                                return true;
                            else return false;
                        }
                        else
                        {
                            if (element.inches.inches == vm.selectedInch.inches && element.brandName.brandName == vm.selectedBrand.brandName && element.seasonType.seasonType == vm.selectedSeasonType.seasonType)
                                return true;
                            else return false;
                        }
                    }
                }
                else
                {
                    if (vm.selectedHeight != "")
                    {
                        if (vm.selectedWidth != "")
                        {
                            if (element.width.width == vm.selectedWidth.width && element.height.height == vm.selectedHeight.height
                                && element.brandName.brandName == vm.selectedBrand.brandName && element.seasonType.seasonType == vm.selectedSeasonType.seasonType)
                                return true;
                            else return false;
                        }
                        else
                        {
                            if (element.height.height == vm.selectedHeight.height && element.brandName.brandName == vm.selectedBrand.brandName && element.seasonType.seasonType == vm.selectedSeasonType.seasonType)
                                return true;
                            else return false;
                        }
                    }
                    else
                    {
                        if (vm.selectedWidth != "")
                        {
                            if (element.width.width == vm.selectedWidth.width && element.brandName.brandName == vm.selectedBrand.brandName && element.seasonType.seasonType == vm.selectedSeasonType.seasonType)
                                return true;
                            else return false;
                        }
                        else
                        {
                            if (element.brandName.brandName == vm.selectedBrand.brandName && element.seasonType.seasonType == vm.selectedSeasonType.seasonType)
                                return true;
                            else return false;
                        }
                    }
                }
            }
            else
            {
                if (vm.selectedInch != "" )
                {
                    if (vm.selectedHeight != "")
                    {
                        if (vm.selectedWidth != "")
                        {
                            if (element.width.width == vm.selectedWidth.width && element.height.height == vm.selectedHeight.height
                                && element.inches.inches == vm.selectedInch.inches && element.brandName.brandName == vm.selectedBrand.brandName)
                                return true;
                            else return false;
                        }
                        else
                        {
                            if (element.height.height == vm.selectedHeight.height && element.inches.inches == vm.selectedInch.inches && element.brandName.brandName == vm.selectedBrand.brandName)
                                return true;
                            else return false;
                        }
                    }
                    else
                    {
                        if (vm.selectedWidth != "")
                        {
                            if (element.width.width == vm.selectedWidth.width
                                && element.inches.inches == vm.selectedInch.inches && element.brandName.brandName == vm.selectedBrand.brandName)
                                return true;
                            else return false;
                        }
                        else
                        {
                            if (element.inches.inches == vm.selectedInch.inches && element.brandName.brandName == vm.selectedBrand.brandName)
                                return true;
                            else return false;
                        }
                    }
                }
                else
                {
                    if (vm.selectedHeight != "")
                    {
                        if (vm.selectedWidth != "")
                        {
                            if (element.width.width == vm.selectedWidth.width && element.height.height == vm.selectedHeight.height
                                && element.brandName.brandName == vm.selectedBrand.brandName)
                                return true;
                            else return false;
                        }
                        else
                        {
                            if (element.height.height == vm.selectedHeight.height && element.brandName.brandName == vm.selectedBrand.brandName)
                                return true;
                            else return false;
                        }
                    }
                    else
                    {
                        if (vm.selectedWidth != "")
                        {
                            if (element.width.width == vm.selectedWidth.width && element.brandName.brandName == vm.selectedBrand.brandName)
                                return true;
                            else return false;
                        }
                        else
                        {
                            if (element.brandName.brandName == vm.selectedBrand.brandName)
                                return true;
                            else return false;
                        }
                    }
                }
            }
        }
       else
        {
            if (vm.selectedSeasonType != "")
            {
                if (vm.selectedInch != "" )
                {
                    if (vm.selectedHeight != "")
                    {
                        if (vm.selectedWidth != "")
                        {
                            if (element.width.width == vm.selectedWidth.width && element.height.height == vm.selectedHeight.height
                                && element.inches.inches == vm.selectedInch.inches && element.brandName.brandName == vm.selectedBrand.brandName && element.seasonType.seasonType == vm.selectedSeasonType.seasonType)
                                return true;
                            else return false;
                        }
                        else
                        {
                            if (element.height.height == vm.selectedHeight.height && element.inches.inches == vm.selectedInch.inches && element.brandName.brandName == vm.selectedBrand.brandName && element.seasonType.seasonType == vm.selectedSeasonType.seasonType)
                                return true;
                            else return false;
                        }
                    }
                    else
                    {
                        if (vm.selectedWidth != "")
                        {
                            if (element.width.width == vm.selectedWidth.width
                                && element.inches.inches == vm.selectedInch.inches && element.brandName.brandName == vm.selectedBrand.brandName && element.seasonType.seasonType == vm.selectedSeasonType.seasonType)
                                return true;
                            else return false;
                        }
                        else
                        {
                            if (element.inches.inches == vm.selectedInch.inches && element.brandName.brandName == vm.selectedBrand.brandName && element.seasonType.seasonType == vm.selectedSeasonType.seasonType)
                                return true;
                            else return false;
                        }
                    }
                }
                else
                {
                    if (vm.selectedHeight != "")
                    {
                        if (vm.selectedWidth != "")
                        {
                            if (element.width.width == vm.selectedWidth.width && element.height.height == vm.selectedHeight.height
                                && element.brandName.brandName == vm.selectedBrand.brandName && element.seasonType.seasonType == vm.selectedSeasonType.seasonType)
                                return true;
                            else return false;
                        }
                        else
                        {
                            if (element.height.height == vm.selectedHeight.height && element.brandName.brandName == vm.selectedBrand.brandName && element.seasonType.seasonType == vm.selectedSeasonType.seasonType)
                                return true;
                            else return false;
                        }
                    }
                    else
                    {
                        if (vm.selectedWidth != "")
                        {
                            if (element.width.width == vm.selectedWidth.width && element.brandName.brandName == vm.selectedBrand.brandName && element.seasonType.seasonType == vm.selectedSeasonType.seasonType)
                                return true;
                            else return false;
                        }
                        else
                        {
                            if (element.seasonType.seasonType == vm.selectedSeasonType.seasonType)
                                return true;
                            else return false;
                        }
                    }
                }
            }
            else
            {
                if (vm.selectedInch != "" )
                {
                    if (vm.selectedHeight != "")
                    {
                        if (vm.selectedWidth != "")
                        {
                            if (element.width.width == vm.selectedWidth.width && element.height.height == vm.selectedHeight.height
                                && element.inches.inches == vm.selectedInch.inches)
                                return true;
                            else return false;
                        }
                        else
                        {
                            if (element.height.height == vm.selectedHeight.height && element.inches.inches == vm.selectedInch.inches)
                                return true;
                            else return false;
                        }
                    }
                    else
                    {
                        if (vm.selectedWidth != "")
                        {
                            if (element.width.width == vm.selectedWidth.width
                                && element.inches.inches == vm.selectedInch.inches)
                                return true;
                            else return false;
                        }
                        else
                        {
                            if (element.inches.inches == vm.selectedInch.inches)
                                return true;
                            else return false;
                        }
                    }
                }
                else
                {
                    if (vm.selectedHeight != "")
                    {
                        if (vm.selectedWidth != "")
                        {
                            if (element.width.width == vm.selectedWidth.width && element.height.height == vm.selectedHeight.height)
                                return true;
                            else return false;
                        }
                        else
                        {
                            if (element.height.height == vm.selectedHeight.height)
                                return true;
                            else return false;
                        }
                    }
                    else
                    {
                        if (vm.selectedWidth != "")
                        {
                            if (element.width.width == vm.selectedWidth.width)
                                return true;
                            else return false;
                        }
                        else
                        {
                                return true;
                        }
                    }
                }
            }
        }
    };

    function filterInches() {
        return true;
    };
    function filterHeights() {
        return true;
    };
    function filterWidths() {
        return true;
    };


}
