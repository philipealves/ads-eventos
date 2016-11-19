app.controller('EventController', function(EventService, PlaceService) {

	var controller = this;

	controller.init = function() {
		findPlaces();
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

	controller.clear = function(id) {
		clear();
	}

	function save() {
		EventService.save(controller.event).success(function(data) {
			clear();
			getAll();
		}).error(function(err) {
			console.log(err);
		});
	}

	function update() {
		EventService.update(controller.event).success(function(data) {
			clear();
			getAll();
		}).error(function(err) {
			console.log(err);
		});
	}

	function remove(id) {
		EventService.remove(id).success(function(data) {
			getAll();
		}).error(function(err) {
			console.log(err);
		});
	}

	function findById(id) {
		EventService.findById(id).success(function(data) {
			controller.event = data;
		}).error(function(err) {
			console.log(err);
		});
	}

	function getAll() {
		EventService.findAll().success(function(data) {
			controller.events = data;
		}).error(function(err) {
			console.log(err);
		});
	}
	
	function findPlaces() {
		PlaceService.findAll().success(function(data) {
			controller.places = data;
		}).error(function(err) {
			console.log(err);
		});
	}

	function clear() {
		controller.event = {};
	}

});