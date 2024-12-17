import pathlib


def parse(puzzle_input) -> list[str]:
    """Parse input."""
    return puzzle_input


def part1(data: list[str]):
    """Solve part 1."""
    files = []
    spaces = []
    even = 0
    for c in data:
        if even % 2 == 0:
            files.append(int(c))
        else:
            spaces.append(int(c))
        even += 1
    index = 0
    checksum = 0
    file_index = 0
    read_files = True
    while True:
        if read_files:
            if len(files) <= file_index:
                break
            file_id = files[file_index]
            for i in range(file_id):
                checksum += index * file_index
                index += 1
            read_files = False
            file_index += 1
        else:
            if len(files) <= file_index:
                break
            while True:
                file_length = files[-1]
                file_id = len(files) - 1
                space_length = spaces[0]
                if space_length == file_length:
                    for i in range(space_length):
                        checksum += index * file_id
                        index += 1
                    files.pop()
                    spaces.pop(0)
                    read_files = True
                    break
                elif space_length > file_length:
                    for i in range(file_length):
                        checksum += index * file_id
                        index += 1
                    spaces[0] = space_length - file_length
                    files.pop()
                elif space_length < file_length:
                    for i in range(space_length):
                        checksum += index * file_id
                        index += 1
                    files[-1] = file_length - space_length
                    spaces.pop(0)
                    read_files = True
                    break

    return checksum


def part2(data: str):
    """Solve part 2."""
    blocks = []
    even = 1
    value = 1
    files = []
    spaces = []
    index = int(data[0])
    for c in data[1:]:
        if even % 2 == 0:
            files.append(int(c))
            blocks.append((value, int(c)))
            value += 1
        else:
            if c == "0":
                even += 1
                continue
            spaces.append(int(c))
            blocks.append((0, int(c)))
        even += 1
    i = len(blocks) - 1
    while i > 0:
        val = blocks[i]
        if val[0] == 0:
            i -= 1
            continue
        for j in range(i):
            if blocks[j][0] != 0 or blocks[j][1] < val[1]:
                continue
            elif blocks[j][1] == val[1]:
                blocks[j] = val
                blocks[i] = (0, val[1])
                break
            elif blocks[j][1] > val[1]:
                blocks[i] = (0, val[1])
                blocks.insert(j + 1, (0, blocks[j][1] - val[1]))
                blocks[j] = val
                i += 1
                break
        i -= 1

    checksum = 0
    for val in blocks:
        if val[0] == 0:
            index += val[1]
        else:
            for i in range(val[1]):
                checksum += val[0] * index
                index += 1

    return checksum


if __name__ == "__main__":
    puzzle_dir = pathlib.Path(__file__).parent
    puzzle_input = (puzzle_dir / "input.txt").read_text().strip()
    data = parse(puzzle_input)

    print(f"Part 1: {part1(data)}")
    print(f"Part 2: {part2(data)}")
