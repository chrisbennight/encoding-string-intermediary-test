encoding-string-intermediary-test
=================================

Testing encoding size when forced to go through a UTF string  (i.e. bytes -> UTF-8 String -> UTF-8 bytes )

Output:
```
Encoding: Bennight Base 2
Average Encoded Bytes (2 original bytes): 17.0
Average Encoded Bytes (3 original bytes): 25.0
Average Encoded Bytes (4 original bytes): 33.0
Average Encoded Bytes (5 original bytes): 41.0
Average Encoded Bytes (6 original bytes): 49.0
Average Encoded Bytes (7 original bytes): 57.0
Average Encoded Bytes (8 original bytes): 65.0
Total Successes: 71434240
Success Rate: 1.0
Time in encode: 0:08:44.604
Time in decode: 0:23:39.100
***************************


Encoding: Bennight Base 4
Average Encoded Bytes (2 original bytes): 9.0
Average Encoded Bytes (3 original bytes): 13.0
Average Encoded Bytes (4 original bytes): 17.0
Average Encoded Bytes (5 original bytes): 21.0
Average Encoded Bytes (6 original bytes): 25.0
Average Encoded Bytes (7 original bytes): 29.0
Average Encoded Bytes (8 original bytes): 33.0
Total Successes: 71434240
Success Rate: 1.0
Time in encode: 0:04:31.915
Time in decode: 0:10:23.793
***************************


Encoding: Bennight Base 8
Average Encoded Bytes (2 original bytes): 6.0
Average Encoded Bytes (3 original bytes): 9.0
Average Encoded Bytes (4 original bytes): 11.0
Average Encoded Bytes (5 original bytes): 14.0
Average Encoded Bytes (6 original bytes): 17.0
Average Encoded Bytes (7 original bytes): 19.0
Average Encoded Bytes (8 original bytes): 22.0
Total Successes: 71434240
Success Rate: 1.0
Time in encode: 0:03:05.284
Time in decode: 0:06:25.902
***************************


Encoding: Bennight Base 16
Average Encoded Bytes (2 original bytes): 5.0
Average Encoded Bytes (3 original bytes): 7.0
Average Encoded Bytes (4 original bytes): 9.0
Average Encoded Bytes (5 original bytes): 11.0
Average Encoded Bytes (6 original bytes): 13.0
Average Encoded Bytes (7 original bytes): 15.0
Average Encoded Bytes (8 original bytes): 17.0
Total Successes: 71434240
Success Rate: 1.0
Time in encode: 0:02:28.658
Time in decode: 0:04:47.536
***************************


Encoding: Bennight Base 32
Average Encoded Bytes (2 original bytes): 4.0
Average Encoded Bytes (3 original bytes): 5.0
Average Encoded Bytes (4 original bytes): 7.0
Average Encoded Bytes (5 original bytes): 9.0
Average Encoded Bytes (6 original bytes): 10.0
Average Encoded Bytes (7 original bytes): 12.0
Average Encoded Bytes (8 original bytes): 13.0
Total Successes: 71434240
Success Rate: 1.0
Time in encode: 0:02:00.650
Time in decode: 0:03:49.458
***************************


Encoding: Bennight Base 64
Average Encoded Bytes (2 original bytes): 3.0
Average Encoded Bytes (3 original bytes): 5.0
Average Encoded Bytes (4 original bytes): 6.0
Average Encoded Bytes (5 original bytes): 7.0
Average Encoded Bytes (6 original bytes): 9.0
Average Encoded Bytes (7 original bytes): 10.0
Average Encoded Bytes (8 original bytes): 11.0
Total Successes: 71434240
Success Rate: 1.0
Time in encode: 0:01:42.823
Time in decode: 0:03:08.459
***************************


Encoding: Bennight Base 85
Average Encoded Bytes (2 original bytes): 3.0
Average Encoded Bytes (3 original bytes): 4.0
Average Encoded Bytes (4 original bytes): 5.9614105224609375
Average Encoded Bytes (5 original bytes): 7.0
Average Encoded Bytes (6 original bytes): 8.0
Average Encoded Bytes (7 original bytes): 9.0
Average Encoded Bytes (8 original bytes): 10.75
Total Successes: 71434240
Success Rate: 1.0
Time in encode: 0:01:39.455
Time in decode: 0:03:08.377
***************************


Encoding: Bennight Base 128
Average Encoded Bytes (2 original bytes): 3.0
Average Encoded Bytes (3 original bytes): 4.0
Average Encoded Bytes (4 original bytes): 5.0
Average Encoded Bytes (5 original bytes): 6.0
Average Encoded Bytes (6 original bytes): 7.0
Average Encoded Bytes (7 original bytes): 9.0
Average Encoded Bytes (8 original bytes): 10.0
Total Successes: 71434240
Success Rate: 1.0
Time in encode: 0:01:27.609
Time in decode: 0:02:32.070
***************************


Encoding: Guava Base 16
Average Encoded Bytes (2 original bytes): 4.0
Average Encoded Bytes (3 original bytes): 6.0
Average Encoded Bytes (4 original bytes): 8.0
Average Encoded Bytes (5 original bytes): 10.0
Average Encoded Bytes (6 original bytes): 12.0
Average Encoded Bytes (7 original bytes): 14.0
Average Encoded Bytes (8 original bytes): 16.0
Total Successes: 71434240
Success Rate: 1.0
Time in encode: 0:00:28.147
Time in decode: 0:00:38.829
***************************


Encoding: Guava Base 32
Average Encoded Bytes (2 original bytes): 8.0
Average Encoded Bytes (3 original bytes): 8.0
Average Encoded Bytes (4 original bytes): 8.0
Average Encoded Bytes (5 original bytes): 8.0
Average Encoded Bytes (6 original bytes): 16.0
Average Encoded Bytes (7 original bytes): 16.0
Average Encoded Bytes (8 original bytes): 16.0
Total Successes: 71434240
Success Rate: 1.0
Time in encode: 0:00:23.337
Time in decode: 0:00:55.243
***************************


Encoding: Guava Base 64
Average Encoded Bytes (2 original bytes): 4.0
Average Encoded Bytes (3 original bytes): 4.0
Average Encoded Bytes (4 original bytes): 8.0
Average Encoded Bytes (5 original bytes): 8.0
Average Encoded Bytes (6 original bytes): 8.0
Average Encoded Bytes (7 original bytes): 12.0
Average Encoded Bytes (8 original bytes): 12.0
Total Successes: 71434240
Success Rate: 1.0
Time in encode: 0:00:21.299
Time in decode: 0:00:47.335
***************************


Encoding: HBase Base 64
Average Encoded Bytes (2 original bytes): 4.0
Average Encoded Bytes (3 original bytes): 4.0
Average Encoded Bytes (4 original bytes): 8.0
Average Encoded Bytes (5 original bytes): 8.0
Average Encoded Bytes (6 original bytes): 8.0
Average Encoded Bytes (7 original bytes): 12.0
Average Encoded Bytes (8 original bytes): 12.0
Total Successes: 71434240
Success Rate: 1.0
Time in encode: 0:01:04.723
Time in decode: 0:05:30.249
***************************


Encoding: Base 91
Average Encoded Bytes (2 original bytes): 3.0
Average Encoded Bytes (3 original bytes): 4.0
Average Encoded Bytes (4 original bytes): 5.0
Average Encoded Bytes (5 original bytes): 6.7965087890625
Average Encoded Bytes (6 original bytes): 7.97198486328125
Average Encoded Bytes (7 original bytes): 8.99853515625
Average Encoded Bytes (8 original bytes): 10.0
Total Successes: 71434240
Success Rate: 1.0
Time in encode: 0:00:56.579
Time in decode: 0:00:59.654
***************************


Encoding: Base 128
Average Encoded Bytes (2 original bytes): 3.0
Average Encoded Bytes (3 original bytes): 4.0
Average Encoded Bytes (4 original bytes): 5.0
Average Encoded Bytes (5 original bytes): 6.0
Average Encoded Bytes (6 original bytes): 7.0
Average Encoded Bytes (7 original bytes): 8.0
Average Encoded Bytes (8 original bytes): 10.0
Total Successes: 71434240
Success Rate: 1.0
Time in encode: 0:00:35.485
Time in decode: 0:00:36.025
***************************
```
