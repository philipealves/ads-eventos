var app = angular.module('adsEventosApp', [ 'ui.router' ]);

app.filter("mydate", function() {
	var re = /\/Date\(([0-9]*)\)\//;
	return function(x) {
		var m = x.match(re);
		if (m)
			return new Date(parseInt(m[1]));
		else
			return null;
	};
});

app.config(function($stateProvider, $urlRouterProvider) {

	$urlRouterProvider.otherwise('/home');

	$stateProvider

	.state('home', {
		url : '/home',
		templateUrl : 'pages/home/partial-home.html'
	}).state('event', {
		url : '/event',
		templateUrl : 'pages/event/partial-event.html'
	}).state('place', {
		url : '/place',
		templateUrl : 'pages/place/partial-place.html'
	}).state('participant', {
		url : '/participant',
		templateUrl : 'pages/participant/partial-participant.html'
	})

});