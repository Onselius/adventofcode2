package year22;

import java.util.*;

public class Dec07 {
    private List<String> lines;
    private Dir rootDir;
    private Dir currentDir;
    private Set<Dir> dirs;

    public Dec07() {
    }

    protected long part1()
    {
        setupTree();

        return dirs.stream()
                .filter(d -> d.getTotalSize() < 100000)
                .mapToLong(Dir::getTotalSize)
                .sum();
    }

    private void setupTree()
    {
        dirs = new HashSet<>();
        rootDir = new Dir(null, "/");
        currentDir = rootDir;
        for (int i = 0; i < lines.size(); i++)
        {
            String[] splitted = lines.get(i).split(" ");
            switch (splitted[1])
            {
                case "cd":
                    cd(splitted[2]);
                    break;
                case "ls":
                    i = ls(i);
                    break;
            }
        }
    }

    private void cd(String arg)
    {
        if (arg.equals("/"))
        {
            currentDir = rootDir;
        }
        else if (arg.equals(".."))
        {
            currentDir = currentDir.parent;
        }
        else
        {
            currentDir = currentDir.getDir(arg);
            dirs.add(currentDir);
        }
    }

    private int ls(int index)
    {
        index++;
        while (index < lines.size() && !lines.get(index).startsWith("$"))
        {
            String[] splitted = lines.get(index).split(" ");
            if (!splitted[0].equals("dir"))
            {
                currentDir.addFile(splitted[1], splitted[0]);
            }
            index++;
        }
        index--;
        return index;
    }

    protected long part2()
    {
        setupTree();

        long totalSize = 70000000;
        long updateSize = 30000000;
        long rootSize = rootDir.getTotalSize();
        long unUsedSize = totalSize - rootSize;
        long sizeNeeded = updateSize - unUsedSize;

        OptionalLong size = dirs.stream()
                .filter(d -> d.getTotalSize() > sizeNeeded)
                .mapToLong(Dir::getTotalSize)
                .min();

        return size.getAsLong();
    }

    public void setLines(List<String> lines)
    {
        this.lines = lines;
    }

    private class Dir {
        private List<File> files;
        private Map<String, Dir> dirs;
        private String name;
        private Dir parent;

        public Dir(Dir parent, String name)
        {
            this.files = new ArrayList<>();
            this.dirs = new HashMap<>();
            this.parent = parent;
            this.name = name;
        }

        void addFile(String name, String size)
        {
            File file = new File(name, Long.parseLong(size));
            this.files.add(file);
        }

        Dir getDir(String name)
        {
            Dir dir = dirs.getOrDefault(name, new Dir(this, name));
            dirs.put(name, dir);

            return dir;
        }

        long getTotalSize()
        {
            long size = 0;
            for (File file: files)
            {
                size += file.getSize();
            }
            for (Dir dir: dirs.values())
            {
                size += dir.getTotalSize();
            }
            return size;
        }

        @Override
        public String toString()
        {
            return "Name: " + name +
                    "\nDirs: " + dirs +
                    "\nFiles: " + files;
        }
    }

    private class File {
        private String name;
        private long size;

        public File(String name, long size)
        {
            this.name = name;
            this.size = size;
        }

        public long getSize()
        {
            return this.size;
        }

        @Override
        public String toString()
        {
            return "File{" +
                    "name='" + name + '\'' +
                    ", size=" + size +
                    '}';
        }
    }
}
