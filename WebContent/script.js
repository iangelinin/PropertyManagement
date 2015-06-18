/**
 * Created by iange_000 on 04-Jun-15.
 */


var app = angular.module("Test",[]);
app.controller("Controller",function($scope,$http){
    function setCurrentProperty(newCurrentProperty) {
        $scope.currentProperty = newCurrentProperty;
    }
    $scope.setCurrentProperty = setCurrentProperty;

    //$scope.currentProperty =  {"property":{"propertyId":0,"propertyName":"Property One","address":"Example street 15","rent":567.56,"isRented":"true"},tenant:{"tenantName":"Jhon Doe","telephone":"+359884738928","email":"j.doe@gde.bg"}};
    /*$scope.payments = [
        {"propertyId":0,"date":"23/05/2015","payer":"Payer","amount":2000.00,"comment":"comment on this payment 1"},
        {"propertyId":0,"date":"23/01/2015","payer":"Payer","amount":2000.00,"comment":"comment on this payment"},
        {"propertyId":0,"date":"23/02/2015","payer":"Payer","amount":2000.00,"comment":"comment on this payment"},
        {"propertyId":0,"date":"23/03/2015","payer":"Payer","amount":2000.00,"comment":"comment on this payment"},
        {"propertyId":0,"date":"23/04/2015","payer":"Payer","amount":2000.00,"comment":"comment on this payment"},
        {"propertyId":0,"date":"23/05/2015","payer":"Payer","amount":2000.00,"comment":"comment on this payment"},
        {"propertyId":0,"date":"23/06/2015","payer":"Payer","amount":2000.00,"comment":"comment on this payment"},
        {"propertyId":0,"date":"23/07/2015","payer":"Payer","amount":2000.00,"comment":"comment on this payment"},
        {"propertyId":0,"date":"23/08/2015","payer":"Payer","amount":2000.00,"comment":"comment on this payment"},
        {"propertyId":0,"date":"23/09/2015","payer":"Payer","amount":2000.00,"comment":"comment on this payment"},
        {"propertyId":0,"date":"23/10/2015","payer":"Payer","amount":2000.00,"comment":"comment on this payment"},
        {"propertyId":0,"date":"23/11/2015","payer":"Payer","amount":2000.00,"comment":"comment on this payment"},
        {"propertyId":0,"date":"23/12/2015","payer":"Payer","amount":2000.00,"comment":"comment on this payment"},
        {"propertyId":1,"date":"23/05/2015","payer":"Payer","amount":2000.00,"comment":"comment on this payment 2"},
        {"propertyId":1,"date":"23/01/2015","payer":"Payer","amount":2000.00,"comment":"comment on this payment"},
        {"propertyId":1,"date":"23/02/2015","payer":"Payer","amount":2000.00,"comment":"comment on this payment"},
        {"propertyId":1,"date":"23/03/2015","payer":"Payer","amount":2000.00,"comment":"comment on this payment"},
        {"propertyId":1,"date":"23/04/2015","payer":"Payer","amount":2000.00,"comment":"comment on this payment"},
        {"propertyId":1,"date":"23/05/2015","payer":"Payer","amount":2000.00,"comment":"comment on this payment"},
        {"propertyId":1,"date":"23/06/2015","payer":"Payer","amount":2000.00,"comment":"comment on this payment"},
        {"propertyId":1,"date":"23/07/2015","payer":"Payer","amount":2000.00,"comment":"comment on this payment"},
        {"propertyId":1,"date":"23/08/2015","payer":"Payer","amount":2000.00,"comment":"comment on this payment"},
        {"propertyId":1,"date":"23/09/2015","payer":"Payer","amount":2000.00,"comment":"comment on this payment"},
        {"propertyId":1,"date":"23/10/2015","payer":"Payer","amount":2000.00,"comment":"comment on this payment"},
        {"propertyId":1,"date":"23/11/2015","payer":"Payer","amount":2000.00,"comment":"comment on this payment"},
        {"propertyId":1,"date":"23/12/2015","payer":"Payer","amount":2000.00,"comment":"comment on this payment"},
        {"propertyId":2,"date":"23/05/2015","payer":"Payer","amount":2000.00,"comment":"comment on this payment"},
        {"propertyId":2,"date":"23/01/2015","payer":"Payer","amount":2000.00,"comment":"comment on this payment"},
        {"propertyId":2,"date":"23/02/2015","payer":"Payer","amount":2000.00,"comment":"comment on this payment"},
        {"propertyId":2,"date":"23/03/2015","payer":"Payer","amount":2000.00,"comment":"comment on this payment"},
        {"propertyId":2,"date":"23/04/2015","payer":"Payer","amount":2000.00,"comment":"comment on this payment"},
        {"propertyId":2,"date":"23/05/2015","payer":"Payer","amount":2000.00,"comment":"comment on this payment"},
        {"propertyId":2,"date":"23/06/2015","payer":"Payer","amount":2000.00,"comment":"comment on this payment"},
        {"propertyId":2,"date":"23/07/2015","payer":"Payer","amount":2000.00,"comment":"comment on this payment"},
        {"propertyId":2,"date":"23/08/2015","payer":"Payer","amount":2000.00,"comment":"comment on this payment"},
        {"propertyId":2,"date":"23/09/2015","payer":"Payer","amount":2000.00,"comment":"comment on this payment"},
        {"propertyId":2,"date":"23/10/2015","payer":"Payer","amount":2000.00,"comment":"comment on this payment"},
        {"propertyId":2,"date":"23/11/2015","payer":"Payer","amount":2000.00,"comment":"comment on this payment"},
        {"propertyId":2,"date":"23/12/2015","payer":"Payer","amount":2000.00,"comment":"comment on this payment"},
        {"propertyId":3,"date":"23/05/2015","payer":"Payer","amount":2000.00,"comment":"comment on this payment"},
        {"propertyId":3,"date":"23/01/2015","payer":"Payer","amount":2000.00,"comment":"comment on this payment"},
        {"propertyId":3,"date":"23/02/2015","payer":"Payer","amount":2000.00,"comment":"comment on this payment"},
        {"propertyId":3,"date":"23/03/2015","payer":"Payer","amount":2000.00,"comment":"comment on this payment"},
        {"propertyId":3,"date":"23/04/2015","payer":"Payer","amount":2000.00,"comment":"comment on this payment"},
        {"propertyId":3,"date":"23/05/2015","payer":"Payer","amount":2000.00,"comment":"comment on this payment"},
        {"propertyId":3,"date":"23/06/2015","payer":"Payer","amount":2000.00,"comment":"comment on this payment"},
        {"propertyId":3,"date":"23/07/2015","payer":"Payer","amount":2000.00,"comment":"comment on this payment"},
        {"propertyId":3,"date":"23/08/2015","payer":"Payer","amount":2000.00,"comment":"comment on this payment"},
        {"propertyId":3,"date":"23/09/2015","payer":"Payer","amount":2000.00,"comment":"comment on this payment"},
        {"propertyId":3,"date":"23/10/2015","payer":"Payer","amount":2000.00,"comment":"comment on this payment"},
        {"propertyId":3,"date":"23/11/2015","payer":"Payer","amount":2000.00,"comment":"comment on this payment"},
        {"propertyId":3,"date":"23/12/2015","payer":"Payer","amount":2000.00,"comment":"comment on this payment"},
        {"propertyId":4,"date":"23/05/2015","payer":"Payer","amount":2000.00,"comment":"comment on this payment"},
        {"propertyId":4,"date":"23/01/2015","payer":"Payer","amount":2000.00,"comment":"comment on this payment"},
        {"propertyId":4,"date":"23/02/2015","payer":"Payer","amount":2000.00,"comment":"comment on this payment"},
        {"propertyId":4,"date":"23/03/2015","payer":"Payer","amount":2000.00,"comment":"comment on this payment"},
        {"propertyId":4,"date":"23/04/2015","payer":"Payer","amount":2000.00,"comment":"comment on this payment"},
        {"propertyId":4,"date":"23/05/2015","payer":"Payer","amount":2000.00,"comment":"comment on this payment"},
        {"propertyId":4,"date":"23/06/2015","payer":"Payer","amount":2000.00,"comment":"comment on this payment"},
        {"propertyId":4,"date":"23/07/2015","payer":"Payer","amount":2000.00,"comment":"comment on this payment"},
        {"propertyId":4,"date":"23/08/2015","payer":"Payer","amount":2000.00,"comment":"comment on this payment"},
        {"propertyId":4,"date":"23/09/2015","payer":"Payer","amount":2000.00,"comment":"comment on this payment"},
        {"propertyId":4,"date":"23/10/2015","payer":"Payer","amount":2000.00,"comment":"comment on this payment"},
        {"propertyId":4,"date":"23/11/2015","payer":"Payer","amount":2000.00,"comment":"comment on this payment"},
        {"propertyId":4,"date":"23/12/2015","payer":"Payer","amount":2000.00,"comment":"comment on this payment"}
    ]*/
    $http.get("http://localhost:8080/PropMngApp/PropertyData").then(function(response){$scope.userData = response.data;
        $scope.properties = $scope.userData.properties;
        $scope.payments = $scope.userData.payments;
        $scope.currentProperty = $scope.properties[0];});
    //$scope.properties=[ {"property":{"propertyId":0,"propertyName":"Property One","address":"Example street 15","rent":567.56,"isRented":"true"},tenant:{"tenantName":"Jhon Doe","telephone":"+359884738928","email":"j.doe@gde.bg"}},
        //{"property":{"propertyId":1,"propertyName":"Property Two","address":"Example street 15","rent":567.56,"isRented":"true"},tenant:{"tenantName":"Jhon Doe","telephone":"+359884738928","email":"j.doe@gde.bg"}},
        //{"property":{"propertyId":2,"propertyName":"Property Three","address":"Example street 15","rent":567.56,"isRented":"true"},tenant:{"tenantName":"Jhon Doe","telephone":"+359884738928","email":"j.doe@gde.bg"}},
        //{"property":{"propertyId":3,"propertyName":"Property Four","address":"Example street 15","rent":567.56,"isRented":"true"},tenant:{"tenantName":"Jhon Doe","telephone":"+359884738928","email":"j.doe@gde.bg"}},
        //{"property":{"propertyId":4,"propertyName":"Property Five","address":"Example street 15","rent":567.56,"isRented":"true"},tenant:{"tenantName":"Jhon Doe","telephone":"+359884738928","email":"j.doe@gde.bg"}}
    //]
    //$scope.properties = [{"propertyId":1,"propertyName":"Shop","address":"\"Example\" str #13","rent":500.0,"tenantName":"Jane Doe","phone":"+359 897 123 654","email":"petar.p@abv.bg"},
      //  {"propertyId":2,"propertyName":"Flat","address":"\"Hello World\" BLVD","rent":300.0,"tenantName":"Jhon Doe","phone":"+359 888 777 555","email":"g.ivanov@gmail.com"}]


});