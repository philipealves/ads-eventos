app.service('PlaceService', function($http) {

	var serviceUrl = "http://localhost:8080/ads-eventos-services/place";

	this.save = function(place) {
		return $http.post(serviceUrl + "/add", place);
	}
	
	this.update = function(place) {
		return $http.put(serviceUrl + "/update", place);
	}
	
	this.remove = function(id) {
		return $http.delete(serviceUrl + "/delete/" + id);
	}
	
	this.findById = function(id) {
		return $http.get(serviceUrl + "/find/" + id);
	}

	this.findAll = function() {
		return $http.get(serviceUrl + "/findAll");
	};

});