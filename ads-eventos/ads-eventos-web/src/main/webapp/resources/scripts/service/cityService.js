app.service('CityService', function($http) {

	var serviceUrl = "http://localhost:8080/ads-eventos-services/city";

	this.findById = function(id) {
		return $http.get(serviceUrl + "/find/" + id);
	}

	this.findByState = function(id) {
		return $http.get(serviceUrl + "/findByState/" + id);
	};

});