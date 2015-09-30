<!DOCTYPE html>
<meta charset="utf-8">
<html>
<head>
    <title>Angular.js nvd3.js Multi Bar Horizontal Chart Directive</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF8">
    <script src="../js/angular.js"></script>
    <script src="../js/d3.js"></script>
    <script src="../js/nv.d3.js"></script>
    <script src="../dist/angularjs-nvd3-directives.js"></script>
    <script src="http://d3js.org/d3.v3.min.js"></script>
    <link rel="stylesheet" href="../stylesheets/nv.d3.css"/>
    

</head>
<body>
<script>
        var app = angular.module("nvd3TestApp", ['nvd3ChartDirectives']);

        function ExampleCtrl($scope){
            $scope.exampleData = [
                {
                    "key": "Series1",
                    "color": "#d62728",
                    "values": [
                        ["Group A" , -1.8746444827653 ],
                        ["Group B" , -8.0961543492239 ],
                        ["Group C" , -0.57072943117674],
                        ["Group D" , -2.4174010336624 ],
                        ["Group E" , -0.72009071426284],
                        ["Group F" , -0.77154485523777],
                        ["Group G" , -0.90152097798131],
                        ["Group H" , -0.91445417330854],
                        ["Group I" , -0.055746319141851]
                    ]
                },
                {
                    "key": "Series2",
                    "color": "#1f77b4",
                    "values": [
                        ["Group A" , 25.307646510375],
                        ["Group B" , 16.756779544553],
                        ["Group C" , 18.451534877007],
                        ["Group D" , 8.6142352811805],
                        ["Group E" , 7.8082472075876],
                        ["Group F" , 5.259101026956],
                        ["Group G" , 0.30947953487127],
                        ["Group H" , 0],
                        ["Group I" , 0]
                    ]
                }
            ];

        }
    </script>
    <nvd3-multi-bar-horizontal-chart
            data="exampleData"
            id="exampleId"
            showXAxis="true"
            showYAxis="true"
            >
        <svg></svg>
    </nvd3-multi-bar-horizontal-chart>
    <p>hilhi ih</p>

</body>
</html>
