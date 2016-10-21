app.service('LocalService', function($http) {

	var serviceUrl = "http://localhost:8080/ads-eventos-services/place";

	this.save = function(local) {
		local.city = {
				id: 1,
				name: "Patos de Minas",
				state: {
						id: 1,
						name: "Minas Gerais"
				}
		}
		return $http.post(serviceUrl + "/add", local);
	}
	
	this.remove = function(local) {
		alert("Remove");
		return local;
	}
	
	this.findById = function(id) {
		alert("findById");
		return id;
	}

	this.findAll = function() {
		return $http.get(serviceUrl + "/findAll");
	};

});