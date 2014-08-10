struct DataBlock {char data[DATA_BLOCK_SIZE];};
DataBlock dataBlocks[NUM_DATA_BLOCKS];
struct INode{std::vector<int> datablocks;};
struct MetaData{
	int size;
        Date last_modifed, created;
        char extra_attributes;
};
std::vector<bool> dataBlockUsed(NUM_DATA_BLOCKS);
std::map<string, INode *> mapFromName;
struct FSBase;
struct File : public FSBase {
	private:
           std::vector<INode *> nodes;
	   MetaData metaData;
};

struct Directory : public FSBase {std::vector<FSBase *> content;};
struct FileSystem {
	init();
	mount(FileSystem*);
	unmount(FileSystem*);
	File createFile(const char * name){}
	Directory createDirectory(const char* name) {}

	void openFile(File * file, FileMode mode){}
	void closeFile(File * file){}
	void writeToFile(File * file, void * data, int num){}
	void readFromFile(File * file, void * res, int numbutes, int position){}
};
