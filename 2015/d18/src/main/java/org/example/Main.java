package org.example;


public class Main {

    static String s = """
            ###.##..##.#..#.##...#..#.####..#.##.##.##..###...#....#...###..#..###..###.#.#.#..#.##..#...##.#..#
            .#...##.#####..##.......#..####.###.##.#..###.###.....#.#.####.##.###..##...###....#.##.....#.#.#.##
            .....#.#.....#..###..####..#.....##.#..###.####.#.######..##......#####.#.##.#########.###..#.##.#.#
            ...###......#.#..###..#.#.....#.##..#.##..###...#.##.#..#..#.##.#..##......##.##.##.######...#....##
            .###.....#...#.#...####.#.###..#..####.#..#.##..####...##.#...#..###...###...####..##....####.##..#.
            ..#....#...#.......#..###.###....#.##..#.....###.#.##.#....#.#....##.##..#.##.#..###.###.##.##..##.#
            ##..#####.#.#....#.#...#.#.####..#....#..#....#.#..#.#####...#..##.#.....#.##..##.####......#.#.##..
            .#..##..#.#.###..##..##...#....##...#..#.#..##.##..###.####.....#.####.#.....##.#.##...#..####..#...
            #.#####.......#####...#...####.#.#.#....#.###.#.##.#####..#.###.#..##.##.#.##....#.##..#....####.#.#
            #.##...#####....##.#.#.....##......##.##...#.##.##...##...###.###.##.#.####.####.##..#.##.#.#.####..
            #.##.##....###.###.#..#..##.##.#..#.#..##..#.#...#.##........###..#...##.#.#.##.......##.....#...###
            ###..#.#..##.##.#.#.#...#..#...##.##.#.########.......#.#...#....########..#.#.###..#.#..#.##..#####
            ####.#.#...#.##.##..#.#...#....#..###..#.#.#.####.#.##.##.#..##..##..#..#####.####.##..########..##.
            .#.#...#..##.#..#..###.#..####.......##.#.#.#.##.#####..#..##...#.##...#..#....#..#..###..####.#....
            ..#.#...#....##...#####..#..#...###.###.....#.###.#....#.#..##...#.##.##.####.#.#.#..#.##.#....#.#..
            #....###.####.##..#.#.###..###.##.##..#.#...###..#.##.#####.##.#######..#.#...##.#..........####.###
            #.#####.#......#.#......#.....##...##.#.#########.#......##..##..##.#..##.##..#....##...###...#.#...
            #..#..##..###.#.#.#.#.....###.#.####.##.##....#.#..##....#.#..#.####..###.##...#######.#####.##.#.#.
            ..###.#........##.#...###..#.##..#.#....##.#......#..#.##..#.#..#.#..#.####.#####..###.##..#.##.#...
            ##.###....#..##...#..#.#......##..#...#..#.####..#.##...##.####.#...#..###...#.#.#....###.##..#.#...
            ..##.##.#.##..##.#..#.###...##..##..#....##..##...####.#..####.###...#.....#..#.##..##..###..#.#...#
            #.#....#.....#...##.#...####..#..##..##.####..##..##...####...#....##.#.#######..##.#......######.#.
            #.#...###.######.######..##..##....#.#......#......#.#.##.#.##.#.#.#...#...#....#.#.#.#..#.##..#...#
            ####.###.#.#.##..#.##.#...#.##...#.##.##...#.....#.#..#.####.##..######.#..#.#..##....#.#.#..#.#.#.#
            ..##......#.#...#.##.##..##..##..#..##..#########.#..###..###.##...#..##.#..#.#.#.######..#....#.#..
            ..##.##.#...###.#...##..######.##.#..####..#..#.#.##.####.##.##.#...##....#...###.##.####..#....#.#.
            ####...###..#.#.##.#.#....###..##.#.#..########..#...#.#...#.##....##.##...#.....#.#.....#.....#....
            .#.###############....#.##..###..#.####.#.##.##..#..#.#...###...##..##.##.#.....##...###.###.....#..
            .###..#..##.##..####.#.###.##.##..#..##....#.#......#......##.#...#.#...#..##.#.#...#...#.##..#.##..
            ###.#.#.########.#.#..####.#..##.#.##.##.###.##..######...#..##.##.#..#.#...#.##..#####.....#.#.#..#
            .##.##..#.#...#####.#.#.###...##...####...#......#...#..####..#.##..........#..#.#..###....######.##
            ..#####...#.#.#.#..#.##..#...#.#..#.##...##..##.##.#.##.#..#.#...#.......##.#...###.....#...#.#.#.##
            ##.##.#..######.##...#.....#.###.#..##.#.#.#..####.#....##.#....####...##....#.#.##.#..###.##.##..##
            .###.##.#..#.###.####..#.##..####.#.#.##..###.#######.###.###...####........##....###.#...#.#.####.#
            ........#..#.#..##..########..........#.##.#..##.#...#.....####....##..#..#.#####.###...#...#.##.###
            .....#..##.####...##.#####..######.##.#.###.####.##.##.#..##.##.######.##......#..#.####..##....#.##
            ##...####....#.##.##.###....#.#...#.####..##.#.##.#.#...####.#.#.#.#...##.###...##...###...######.##
            .#....#.#.####...#.##.....##...###.#.#.##...##.#####....#.######.#.#....##..##...##....##.#.##.#.#.#
            .###..###.#.......#.#######..#.#.#.######....#.#####.#.....#.#########...#....##...##.####.#..#.....
            ##.#..##..##.....#..##...#..##.##.#..#.#####.##.##.#.##.##...##.######.####..#.##..#####.##...##..#.
            #.###...##.#.#.#.##....#.#.##.##..#....#...#.#.........#..#..####..####.####..#.##.##.#....####..##.
            .#..######..#####.####.##.#.....#.#.#####..##..###.#.#.#..#.#...#.#######..##....##.##...#######..#.
            #...#....#.#.##..#####..#########..#.....#...##.#.#.###...#####..##...##...####.......#######.#..###
            .#......#...##.###..#....#...#.#.....#.#...##.#.#..#..###.##.###.#.##..##...#.##......#.###..#.#..##
            .#....####...###..#.....##..#...#.#.###.#.#.##...#.##.##.#.#.#..####..###.#.#.#.##.#.#...#..#...####
            ......##.##.#...#####.##..#.###..#.#####..##.#..##.###......#...#...#..#......###.######...#.#.##..#
            ###..#...#.##..###.#....##...#..#####.#.#..#.###...#####.#....##..####.#.##...#.#...##..#.#.#.#..#.#
            ...##.#.##.##..#.#.#.###.#.#...#.....###.###.##...#.###.##...##..#..###.#..##.##..###.#....###..##..
            .##.#..###..###.##.##...#..#####...#.....#####.##..####...#.##.#.#..##.#.#.#....###.....#....##.....
            ######.#..#.#..#....#.###...####.####.#.........#..##.#..##..##.....#..#.##.##...#...#####.#.##..#.#
            .##.###...####....#.####...#####..#..#...#..#.....###.#..#.###..#.###.#.......##.####..#.##.#...##..
            ........#.#.##.#.....#####.###......##..#.##.#..#...####.#...#..###.#.#...##..#.#...#.####...#.#.###
            .#..#.##..##...######.###.##.#.#...#.#.#.#.##..##..##.#.##..#....#.##...#.##.##...##....##.###.##.#.
            ##...#...#...###.#.#...#...#..###......##.#.#....##..##.#..##.#.######...#..##.#.##.#.#....#.##.##..
            ...#..###.#....#...#.##..##.#.##.#..###.##..#.##..####.#########....#.....##.#.##.##..##.##.######.#
            #.##.#..##.......###...#.###....###.#..####..##.#####.##.###....##....#.###...####..#.#.#.##.....###
            .......#...#...##.#...##.#.#..#.##..##.#....###...##.#####...#.........#.......###.##.#.#.###....##.
            ###.#.##.##.....#.#..#.#..####.####..#..###..........####.#.##...#######.###..#####..#.....#..###..#
            #...##.##..####.##.###.#.#######..###.#..#######..#.##.####...#..#.##.####..####.#.#.......####.#...
            ...#.##..#..#..##........#.#..#..#.#....#.###.#.###..#.......###..#.....#....#..##.#...#.###...##.#.
            ###.##..#.##.#.#####..#.##.####....#####..###.#.#..#...#...###.#.##..#.#.#.....#.####.#.#.#.#.#.#...
            ..##..##..#..##.##.#...#..#....####....#...#..####..#.....######.###.####.#....##....##.#.#.###....#
            .#.#.#.##..####..#.....#.####.#....#.....#....#.##..#.#..#.#...#.#.#.#..#..#..##.#....####.......#..
            ..##.##..###......#...#..##...#.###.####.#...#.####..#.#.#.....#.#...####...#.########.##.#.#.#..###
            #....#.##.....##.###.##.###..#.####.....####.##...#..##.###...###..###.#....####.#..#..#..#.#..##.#.
            .#.#.##....#.##......#.#..###.#....###....#......#.#.##.##.#########..##..#...#.####..#...####..#..#
            .#.#.......##.#.##.#...#...#.##.#..#.#.#.##....#..###.###.##.#.#...##.#..#..##....#..###.#...#.#.##.
            #.##.#....####...#..##..#.#.#.#.##.#...#####.#...#..#..#.####.####.#.#....#......##..##..###...#..##
            ..##.###..##.####..#..#..##...###.#.#.#######.####...####......##.##..#...#.##...##....#..#..#.....#
            ....#..#..#.#.####.#...##..#....####.#..####...#.#...###...#..#..##...#....##...#.....#.#..#.#.#...#
            ...#.#.#.##..##.###..#.######....####.###...##...###.#...##.####..#.#..#.#..#.##.....#.#.#..##......
            .#.##.##.....##.#..###.###.##....#...###.#......#...##.###.#.##.##...###...###...#.######..#......#.
            ###..#...#......#..##...#....##.#..###.##.####..##..##....####.#...#.#....##..#.#######..#.#.#####..
            ##...#####..####..##....#.#.###.##.#..#.#..#.....###...###.#####.....#..##.#......#...#.###.##.##...
            ...#.#.#..#.###..#.#.#....##.#.#..####.##.#.####.#.#.#...#....##....#.##.####..###.#.#...##.#..#..##
            #.#.#..#.##..##.##.#...##.#....#...###..##..#.#######.#.###..##......##.#..###.########.#.##..#.#.##
            ######.###....##..#..#...####....#.#.#..#...#..######.#.#.##..##....##....##.##.##...#..#.####.#.#..
            #####.###..#..###......##...##.####.#.#.#.###.......##..##.####..##.####.#..#..####..#.####.#####...
            ##.#.#.###..##.#.##.#.#.#.##.#...##........###.#.##..####....###.#.####.####.#.......##.##.##...##..
            #.#..###...#..##.....##.#..#.#..##..######.#####...###.#.......###...#..##..#..#..##.#.#....#..#..#.
            #.#..####.###..#...#...#...#.###..#.#.#.#.#.#.#..#....#.##.##.##..###..####.#..##..##.###.###....##.
            #..#.##.#####........#..#.##.#..##.#...#....#..#.##..###..##..##.##..#..##.#.#...#.#.##.#.##....#.#.
            .......##..#.....#..#.#.....#.##...####.###..####..#.#.#.#..#.....#....##...#..#.##..###.#.#....#...
            #...###########.##.....##...###.#.##.##..####.##...#.####.#####.#####.####...###.##...##..#.#.###..#
            ....#.#.###.####.###...#...#.#..###.#.#.##...#..#.#.#..#.####..#..###.######.#.####.###...###.#.##.#
            .....#..#..########...#.#.#.#.#.#.#.#..###.##..####...##.#.#.#...##..#####.##.#...#.####.#######.##.
            .......#...#.#..#..#...#..#..##.....#.##....##.##...##..##.##...##...#.#..#.##.#.###.#.####.#.#..##.
            .####...#...#.#.#....##..........##.##.###.##.#.#..#.#.#......########.#...#.####.##.###..##...####.
            #.#.#...##.###..##..#..#.....####.#.....##.##.#..#.#.###.#..#######...##..#.#..#.#..############.###
            .##..####.#..#.....###..#..#.#.....#.#.#...##.##.#....#..#..###.#...#....#.#...####..#.....###.####.
            ..#...#.###.###....##.#..#.##..####.##.#.##.##.##...###.####..#.#.#.##.#.#.#..###..##.##.##.##.#..##
            #...............##.....######.#.#####.##.#....#.#..#.##...#.##....#........##.##...#.##.##.#..#.##.#
            #..##..#.#.#.##.#..#.#.##.##...#...#..#.#.##..#.#...###...##...###..#####.#.#..#..#.#..#.#.##...##.#
            .#######.#.....##...#.#.####.######.#..#......#....##.#.#..#..###.#...###...#....#.#..#.##.#...#.#..
            #.###......##.#.##..#.###.###..####..##....#..###......##..##..#####.####....#...###.....###.#..#...
            ###...#....###.#..#.###.##...###.##.......##.##.#.#.#....####....###..##.###...#..##....#.#.##..##..
            .##.......##.######.#.#..#..##....#####.###.#.##.....####....#......####....#.##.#.##..#.##...##.#.#
            .#.###...#.#.#.##.###..###...##..#.##.##..##..#.....###.#..#.##.##.####........##.#####.#.#....#...#
            ##...##..#.##.#######.###.#.##.#####....##.....##.#.....#.#.##.#....#.##.#....##.#..#.###..#..#.#...
            .#..#.#.#.#...#.##...###.##.#.#...###.##...#.#..###....###.#.###...##..###..#..##.##....###...###.##
                        """;

    public static void main(String[] args) {
        Lights lights = new Lights(s);
        int n = 100;
        // part1
        for (int i = 0; i < n; i++) {
            lights.changeState();
        }
        System.out.println(lights.numberOfLightsOn());

        // part2
        Lights lights1 = new Lights(s);
        for (int i = 0; i < n; i++) {
            lights1.changeStateFixCornerLightsOn();
        }
        System.out.println(lights1.numberOfLightsOn());

    }
}