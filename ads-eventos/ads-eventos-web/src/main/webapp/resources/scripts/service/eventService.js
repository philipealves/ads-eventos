app.service('EventService', function($http) {

	var serviceUrl = "http://localhost:8080/ads-eventos-services/event";

	this.save = function(event) {
		return $http.post(serviceUrl + "/add", event);
	}
	
	this.update = function(event) {
		return $http.put(serviceUrl + "/update", event);
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
	
	this.signIn = function(eventId, participant) {
		return $http.post(serviceUrl + "/signIn/" + eventId, participant);
	}

});