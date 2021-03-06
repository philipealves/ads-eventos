app.controller('PlaceController', function(PlaceService, StateService, CityService) {
	
	var controller = this;

	controller.init = function() {
		findStates();
		getAll();		
	}

	controller.save = function() {
		save();
	}

	controller.update = function() {
		update();
	}

	controller.remove = function(id) {
		remove(id);
	}

	controller.findById = function(id) {
		findById(id);
	}

	controller.findAll = function() {
		getAll();
	}

	controller.findCities = function() {
		findCities();
	}

	controller.listCities = function(id) {
		listCities(id);
	}

	controller.clear = function(id) {
		clear();
	}

	function save() {
		PlaceService.save(controller.place).success(function(data) {
			clear();
			getAll();
		}).error(function(err) {
			console.log(err);
		});
	}

	function update() {
		PlaceService.update(controller.place).success(function(data) {
			clear();
			getAll();
		}).error(function(err) {
			console.log(err);
		});
	}

	function remove(id) {
		PlaceService.remove(id).success(function(data) {
			getAll();
		}).error(function(err) {
			console.log(err);
		});
	}

	function findById(id) {
		PlaceService.findById(id).success(function(data) {
			controller.place = data;
			listCities(data.city.state.id);
		}).error(function(err) {
			console.log(err);
		});
	}

	function getAll() {
		PlaceService.findAll().success(function(data) {
			controller.places = data;
		}).error(function(err) {
			console.log(err);
		});
	}

	function findStates() {
		StateService.findAll().success(function(data) {
			controller.states = data;
		}).error(function(err) {
			console.log(err);
		});
	}

	function listCities(id) {
		CityService.findByState(id).success(function(data) {
			controller.cities = data;
		}).error(function(err) {
			console.log(err);
		});
	}

	function clear() {
		controller.place = {};
	}

});