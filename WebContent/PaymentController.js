angular.module('PropertyManagementApp').controller('PaymentController', ['$scope', '$http', function($scope, $http){
	function setCurrentProperty(newCurrentProperty) {
        $scope.currentProperty = newCurrentProperty;
        $scope.isCreating = false;
        $scope.editingTenant = false;
    }
    $scope.setCurrentProperty = setCurrentProperty;
    $scope.currentProperty = null;
    $scope.isCreating = false;
    $scope.newPayment = {
            payer: '',
            date: "",
            amount: "",
            comment: ""};
    $scope.currentPayment = {
    		id: -1,
    		propertyId: "",
    		date: "",
    		comment: "",
    		amount: "",
    		payer: "",
    		rentsId: ""
    		};
   
    function startEditing(payment){
    	$scope.currentPayment = payment;   
    	$scope.isCreating = false;
        resetPayment();
    }
    function shouldEdit(payment){
    
    	return payment.id==$scope.currentPayment.id;
    	
    }
    function resetCurrentPayment(){
    	$scope.currentPayment = {
        		id: -1,
        		propertyId: "",
        		date: "",
        		comment: "",
        		amount: "",
        		payer: "",
        		rentsId: ""
        		};	
    	
    }
    
    function normalPayment(payment){
    	return payment.id!=$scope.currentPayment.id;
    }
    function startCreating(){
        $scope.isCreating = true;
        resetCurrentPayment();
    }
    
    function stopCreating(){
        $scope.isCreating = false;
        resetPayment();
        
    }
    function shouldCreate(){
        return $scope.isCreating;
    }
    $scope.startCreating = startCreating;
    $scope.stopCreating = stopCreating;
    $scope.shouldCreate = shouldCreate;
    $scope.startEditing = startEditing;
    $scope.shouldEdit = shouldEdit;
    $scope.normalPayment = normalPayment;
    
    function resetPayment() {
        $scope.newPayment = {
            payer: '',
            date: "",
            amount: "",
            comment: ""
        }
    }
    //Parsing the date for the DB
    function dateParser(date){
    	if(date.getDate()>9){
    		if(date.getMonth()>9)return date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate();
    		else return date.getFullYear()+"-0"+(date.getMonth()+1)+"-"+date.getDate();
    	}
    	else{
    		if(date.getMonth()>9)return date.getFullYear()+"-0"+(date.getMonth()+1)+"-"+date.getDate();
    		else return date.getFullYear()+"-0"+(date.getMonth()+1)+"-0"+date.getDate();
    	}
    }
    // Creating new payment
 
    function createNewPayment(newPayment){
    	 newPayment.date = dateParser(newPayment.date);
        newPayment.propertyId = $scope.currentProperty.propertyId;
        newPayment.rentsId = $scope.currentProperty.rentsId;
        
        $scope.payments.unshift(newPayment);
        var postPayment = newPayment;
        
     
       
       $http.post("http://localhost:8080/PropMngApp/PaymentREST",postPayment).
        success(function(data, status, headers, config) {
           console.log("Succsess");
           newPayment.id = data.id;
           console.log(newPayment);
           console.log(data);
        }).error(function(data, status, headers, config) {
            console.log("Fail"); });
       

        resetPayment();
       $scope.isCreating = false;
       resetCurrentPayment();

    }
    function editPayment(payment){
    	$http.put("http://localhost:8080/PropMngApp/PaymentREST",payment).
        success(function(data, status, headers, config) {
           console.log("Succsess");
        }).error(function(data, status, headers, config) {
            console.log("Fail"); });

        resetCurrentPayment();
    	
    }
    function deletePayment(payment){
    	$scope.payments.splice($scope.payments.indexOf(payment),1);
    	$http.delete("http://localhost:8080/PropMngApp/PaymentREST", {params: {id: payment.id}}).
        success(function(data, status, headers, config) {
           console.log("Succsess");
        }).error(function(data, status, headers, config) {
            console.log("Fail"); });
    	
    	resetCurrentPayment();
    }
    $scope.editPayment = editPayment;
    $scope.createNewPayment = createNewPayment;
    $scope.deletePayment = deletePayment;
    //Getting the data from server
    $http.get("http://localhost:8080/PropMngApp/PropertyREST").then(function(response){$scope.userData = response.data;
        $scope.properties = $scope.userData.properties;
        $scope.payments = $scope.userData.payments.reverse();
        $scope.currentProperty = $scope.properties[0];});
    
    //Editting tenant
    $scope.editingTenant = false;
    function startEditingTenant(){
    	console.log("Editing");
    	$scope.editingTenant = true;
    }
    function isEditingTenant(){
    	
    	return $scope.editingTenant;
    }
    function editTenant(){
    	$http.put("http://localhost:8080/PropMngApp/TenantREST",{
        	id : $scope.currentProperty.tenant.id,
        	name : $scope.currentProperty.tenant.name,
        	phone : $scope.currentProperty.tenant.phone,
        	email : $scope.currentProperty.tenant.email}).
        success(function(data, status, headers, config) {
           console.log("Succsess");
        }).error(function(data, status, headers, config) {
            console.log("Fail"); });
    	$scope.editingTenant = false;
    }
    $scope.startEditingTenant = startEditingTenant;
    $scope.isEditingTenant = isEditingTenant;
    $scope.editTenant = editTenant;
    
    

}]);