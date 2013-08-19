<html>
  <head>
    <script type="text/javascript" src="https://www.google.com/jsapi"></script>
    
    <script type="text/javascript">
    var x = 10;
    google.load("visualization", "1", {packages: ["corechart"]});
    google.setOnLoadCallback(drawChart);
    function drawChart() {
        var options = {
            width: 1000,
            height: 240,
            lineWidth: 0.2,
            pointSize: 5,
            animation: {
                duration: 1000,
                easing: 'in'
            }
        };

        var chart = new google.visualization.LineChart(document.getElementById('chart_div'));

        var data = new google.visualization.DataTable();
        data.addColumn('string', 'x');
        data.addColumn('number', 'DTV0');
        data.addColumn('number', 'DTV1');
        data.addColumn('number', 'DTV2');
        data.addColumn('number', 'DTV3');

        var button = document.getElementById('b1');

        function drawChart() {
            // Disabling the button while the chart is drawing.
            button.disabled = true;
            google.visualization.events.addListener(chart, 'ready',
                    function () {
                        button.disabled = false;
                    });
            chart.draw(data, options);
        }
        button.onclick = function () {
            if (data.getNumberOfRows() > 50) {
                data.removeRow(0);
            }
            // Generating a random x, y pair and inserting it so rows are sorted.
            x =  new Date();//Math.floor(Math.random() * 1000);
            var y0 = Math.floor(Math.random() * 100);
            var y1 = Math.floor(Math.random() * 100);
            var y2 = Math.floor(Math.random() * 100);
            var y3 = Math.floor(Math.random() * 100);
            var where = 0;
            while (where < data.getNumberOfRows() && parseInt(data.getValue(where, 0)) < x) {
                where++;
            }
            data.insertRows(where, [
                [x.getHours() + ':' + x.getMinutes() + ':' + x.getSeconds(), y0, y1, y2, y3]
            ]);
            drawChart();
        }

        drawChart();
    }
</script>
  </head>
  <body>
      <div id="chart_div"></div>
    <input id="b1" type="button">
  </body>
</html>