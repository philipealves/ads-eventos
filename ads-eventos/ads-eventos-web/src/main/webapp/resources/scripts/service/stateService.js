app.service('StateService', function($http) {

	var serviceUrl = "http://localhost:8080/ads-eventos-services/state";

	this.findById = function(id) {
		return $http.get(serviceUrl + "/find/" + id);
	}

	this.findAll = function() {
		return $http.get(serviceUrl + "/findAll");
	};

});