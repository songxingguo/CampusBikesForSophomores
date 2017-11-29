/*
 * 内容为'空'时的占位显示, ie8及以下浏览器不支持动画效果
 * */
define(["angularAMD", "jquery", "particles", "css!null.less"], function(angularAMD, $, particles){

	angularAMD.directive("null", function() {
		return {
			restrict: 'EA',
			template:"<div class='null-wrap'><h1>空无一物</h1></div>",
			replace:true,
			transclude: true,
			link: function(scope, elem, attr, ctrl) {
				elem.attr('id','particles' + (Math.random()*1000 | 0));
				particlesJS(elem.attr('id'), {
					"particles": {
						"number": {
							"value": 10,
							"density": {
								"enable": true,
								"value_area": 100
							}
						},
						"color": {
							"value": "#EAEAEA"
						},
						"shape": {
							"type": "circle",
							"stroke": {
								"width": 0,
								"color": "#EAEAEA"
							},
							"polygon": {
								"nb_sides": 5
							}
						},
						"opacity": {
							"value": 0.5,
							"random": false,
							"anim": {
								"enable": false,
								"speed": 1,
								"opacity_min": 0.1,
								"sync": false
							}
						},
						"size": {
							"value": 7,
							"random": true,
							"anim": {
								"enable": false,
								"speed": 40,
								"size_min": 0.1,
								"sync": false
							}
						},
						"line_linked": {
							"enable": true,
							"distance": 150,
							"color": "#EAEAEA",
							"opacity": 0.4,
							"width": 1
						},
						"move": {
							"enable": true,
							"speed": 2,
							"direction": "none",
							"random": false,
							"straight": false,
							"out_mode": "out",
							"bounce": false,
							"attract": {
								"enable": false,
								"rotateX": 600,
								"rotateY": 1200
							}
						}
					},
					"interactivity": {
						"detect_on": "canvas",
						"events": {
							"onhover": {
								"enable": false,
								"mode": "grab"
							},
							"onclick": {
								"enable": false,
								"mode": "push"
							},
							"resize": true
						},
						"modes": {
							"grab": {
								"distance": 140,
								"line_linked": {
									"opacity": 1
								}
							},
							"bubble": {
								"distance": 400,
								"size": 40,
								"duration": 2,
								"opacity": 8,
								"speed": 3
							},
							"repulse": {
								"distance": 200,
								"duration": 0.4
							},
							"push": {
								"particles_nb": 4
							},
							"remove": {
								"particles_nb": 2
							}
						}
					},
					"retina_detect": true
				});
			}
		};
	});
});