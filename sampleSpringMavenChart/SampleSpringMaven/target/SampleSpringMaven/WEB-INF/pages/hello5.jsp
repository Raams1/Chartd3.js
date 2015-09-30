<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Population Projection</title>
</head>
<style>
.chart {
    background-color: #eee;
}

.chart rect {
	stroke: white;
    fill: steelblue;
}

.axis {
    shape-rendering: crispEdges;
}

.x.axis line {
    stroke: black;
}

.y.axis line {
    stroke: black;
}

.axis text {
    font-size: 12px;
}



</style>
<body>

    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
    <script src="http://d3js.org/d3.v2.min.js" charset="utf-8"></script>
    <script>


$( function() {

    var json = [
        {
            "Year": "2000",
            "Population": "6,088,683,554",
            "Annual growth rate (%)": "1.25",
            "Population change": "76,640,086"
        },
        {
            "Year": "2001",
            "Population": "6,165,323,640",
            "Annual growth rate (%)": "1.23",
            "Population change": "76,394,040"
        },
        {
            "Year": "2002",
            "Population": "6,241,717,680",
            "Annual growth rate (%)": "1.21",
            "Population change": "75,708,715"
        },
        {
            "Year": "2003",
            "Population": "6,317,426,395",
            "Annual growth rate (%)": "1.19",
            "Population change": "75,694,545"
        },
        {
            "Year": "2004",
            "Population": "6,393,120,940",
            "Annual growth rate (%)": "1.18",
            "Population change": "76,008,796"
        },
        {
            "Year": "2005",
            "Population": "6,469,129,736",
            "Annual growth rate (%)": "1.18",
            "Population change": "76,754,703"
        },
        {
            "Year": "2006",
            "Population": "6,545,884,439",
            "Annual growth rate (%)": "1.18",
            "Population change": "77,687,516"
        },
        {
            "Year": "2007",
            "Population": "6,623,571,955",
            "Annual growth rate (%)": "1.16",
            "Population change": "77,193,924"
        },
        {
            "Year": "2008",
            "Population": "6,700,765,879",
            "Annual growth rate (%)": "1.13",
            "Population change": "76,151,586"
        },
        {
            "Year": "2009",
            "Population": "6,776,917,465",
            "Annual growth rate (%)": "1.12",
            "Population change": "76,101,949"
        },
        {
            "Year": "2010",
            "Population": "6,853,019,414",
            "Annual growth rate (%)": "1.1",
            "Population change": "76,078,737"
        },
        {
            "Year": "2011",
            "Population": "6,929,098,151",
            "Annual growth rate (%)": "1.09",
            "Population change": "75,690,177"
        },
        {
            "Year": "2012",
            "Population": "7,004,788,328",
            "Annual growth rate (%)": "1.07",
            "Population change": "75,387,222"
        },
        {
            "Year": "2013",
            "Population": "7,080,175,550",
            "Annual growth rate (%)": "1.06",
            "Population change": "75,338,512"
        },
        {
            "Year": "2014",
            "Population": "7,155,514,062",
            "Annual growth rate (%)": "1.04",
            "Population change": "75,049,628"
        },
        {
            "Year": "2015",
            "Population": "7,230,563,690",
            "Annual growth rate (%)": "1.03",
            "Population change": "74,655,713"
        },
        {
            "Year": "2016",
            "Population": "7,305,219,403",
            "Annual growth rate (%)": "1.01",
            "Population change": "74,180,657"
        },
        {
            "Year": "2017",
            "Population": "7,379,400,060",
            "Annual growth rate (%)": "0.99",
            "Population change": "73,486,592"
        },
        {
            "Year": "2018",
            "Population": "7,452,886,652",
            "Annual growth rate (%)": "0.97",
            "Population change": "72,652,993"
        },
        {
            "Year": "2019",
            "Population": "7,525,539,645",
            "Annual growth rate (%)": "0.95",
            "Population change": "71,699,093"
        },
        {
            "Year": "2020",
            "Population": "7,597,238,738",
            "Annual growth rate (%)": "0.93",
            "Population change": "70,803,837"
        },
        {
            "Year": "2021",
            "Population": "7,668,042,575",
            "Annual growth rate (%)": "0.91",
            "Population change": "69,932,250"
        },
        {
            "Year": "2022",
            "Population": "7,737,974,825",
            "Annual growth rate (%)": "0.89",
            "Population change": "68,927,398"
        },
        {
            "Year": "2023",
            "Population": "7,806,902,223",
            "Annual growth rate (%)": "0.87",
            "Population change": "67,841,959"
        },
        {
            "Year": "2024",
            "Population": "7,874,744,182",
            "Annual growth rate (%)": "0.84",
            "Population change": "66,699,289"
        },
        {
            "Year": "2025",
            "Population": "7,941,443,471",
            "Annual growth rate (%)": "0.82",
            "Population change": "65,627,670"
        },
        {
            "Year": "2026",
            "Population": "8,007,071,141",
            "Annual growth rate (%)": "0.8",
            "Population change": "64,618,718"
        },
        {
            "Year": "2027",
            "Population": "8,071,689,859",
            "Annual growth rate (%)": "0.78",
            "Population change": "63,569,367"
        },
        {
            "Year": "2028",
            "Population": "8,135,259,226",
            "Annual growth rate (%)": "0.77",
            "Population change": "62,498,636"
        },
        {
            "Year": "2029",
            "Population": "8,197,757,862",
            "Annual growth rate (%)": "0.75",
            "Population change": "61,409,243"
        },
        {
            "Year": "2030",
            "Population": "8,259,167,105",
            "Annual growth rate (%)": "0.73",
            "Population change": "60,387,312"
        },
        {
            "Year": "2031",
            "Population": "8,319,554,417",
            "Annual growth rate (%)": "0.71",
            "Population change": "59,434,876"
        },
        {
            "Year": "2032",
            "Population": "8,378,989,293",
            "Annual growth rate (%)": "0.7",
            "Population change": "58,473,280"
        },
        {
            "Year": "2033",
            "Population": "8,437,462,573",
            "Annual growth rate (%)": "0.68",
            "Population change": "57,495,609"
        },
        {
            "Year": "2034",
            "Population": "8,494,958,182",
            "Annual growth rate (%)": "0.66",
            "Population change": "56,487,279"
        },
        {
            "Year": "2035",
            "Population": "8,551,445,461",
            "Annual growth rate (%)": "0.65",
            "Population change": "55,520,922"
        },
        {
            "Year": "2036",
            "Population": "8,606,966,383",
            "Annual growth rate (%)": "0.63",
            "Population change": "54,605,240"
        },
        {
            "Year": "2037",
            "Population": "8,661,571,623",
            "Annual growth rate (%)": "0.62",
            "Population change": "53,671,305"
        },
        {
            "Year": "2038",
            "Population": "8,715,242,928",
            "Annual growth rate (%)": "0.6",
            "Population change": "52,712,536"
        },
        {
            "Year": "2039",
            "Population": "8,767,955,464",
            "Annual growth rate (%)": "0.59",
            "Population change": "51,724,342"
        },
        {
            "Year": "2040",
            "Population": "8,819,679,806",
            "Annual growth rate (%)": "0.57",
            "Population change": "50,774,182"
        },
        {
            "Year": "2041",
            "Population": "8,870,453,988",
            "Annual growth rate (%)": "0.56",
            "Population change": "49,865,285"
        },
        {
            "Year": "2042",
            "Population": "8,920,319,273",
            "Annual growth rate (%)": "0.55",
            "Population change": "48,921,986"
        },
        {
            "Year": "2043",
            "Population": "8,969,241,259",
            "Annual growth rate (%)": "0.53",
            "Population change": "47,940,235"
        },
        {
            "Year": "2044",
            "Population": "9,017,181,494",
            "Annual growth rate (%)": "0.52",
            "Population change": "46,926,143"
        },
        {
            "Year": "2045",
            "Population": "9,064,107,637",
            "Annual growth rate (%)": "0.51",
            "Population change": "45,941,983"
        },
        {
            "Year": "2046",
            "Population": "9,110,049,620",
            "Annual growth rate (%)": "0.49",
            "Population change": "44,990,101"
        },
        {
            "Year": "2047",
            "Population": "9,155,039,721",
            "Annual growth rate (%)": "0.48",
            "Population change": "44,017,110"
        },
        {
            "Year": "2048",
            "Population": "9,199,056,831",
            "Annual growth rate (%)": "0.47",
            "Population change": "43,026,715"
        },
        {
            "Year": "2049",
            "Population": "9,242,083,546",
            "Annual growth rate (%)": "0.45",
            "Population change": "42,023,878"
        }
    ];

    var results,
        data = [],
        chart,
        bars,
        margin = 100,
        w = 20,
        h = 500,
        x, y,
        xAxis, yAxis;

    results = d3.map( json );
    results.forEach( function( key, val ) {
        var result = {};
        result.year = new Date(parseInt( val.Year, 10), 0, 1);
        result.population = parseInt( val.Population.replace( /,/g, '' ), 10 );
        data.push( result );
    } );

    chart = d3.select( 'body' ).append( 'svg' )
        .attr( 'class', 'chart' )
        .attr( 'width', 1100 )
        .attr( 'height', h )
        .append('g');

    d3.select('svg g')
        .attr('transform', 'translate(80, 50)');

    x = d3.time.scale()
        .domain( [data[0].year, d3.time.year.offset(data[data.length - 1].year, 1)] )
        .range( [0, w * data.length] )

    y = d3.scale.linear()
        .domain( [0, d3.max( data, function( d ) { return d.population; } )] )
        .rangeRound( [0, h - margin] );

    // Bars
    bars = chart.append('g')
        .attr('class', 'bars');

    bars.selectAll( 'rect' )
        .data( data )
      .enter().append( 'rect' )
        .attr( 'x', function( d, i ) { return x( d.year ) - .5; } )
        .attr( 'y', function( d ) { return (h - margin) - y( d.population ) + .5 } )
        .attr( 'width', w )
        .attr( 'height', function( d ) { return y( d.population ) } )
        .append('g');

    // Axis
    xAxis = d3.svg.axis()
        .scale(x)
        .ticks(20)
        .tickSize(6, 3, 1);

    yAxis = d3.svg.axis()
        .scale(d3.scale.linear().domain( [0, d3.max( data, function( d ) { return d.population; } )] ).rangeRound( [h - margin, 0] ))
        .tickSize(6, 3, 1)
        .orient('left');

    chart.append('g')
        .attr('class', 'x axis')
        .attr('transform', 'translate(0, ' + (h - margin) + ')')
        .call(xAxis);

    chart.append('g')
        .attr('class', 'y axis')
        .attr('transform', 'translate(' - y.range()[1] + ')')
        .call(yAxis);

} );









</script>

</body>
</html>