using namespace std;

class Lock {
public: 
    Lock(){}
    ~Lock(){}
    void AcquireLock(){}
    void ReleaseLock(){}
};

template <class T> class Singleton {
    private:
        static Lock lock;
        static T* object;
    protected:
        Singleton(){}
    public:
        static T* instance();
};

//Lock Singleton::lock;
T* Singleton::instance(){
    if (object == 0){
        lock.AcquireLock();
        if (object == 0){
            object = new T;
        }
        lock.ReleaseLock();
    }
    return object;
}

int main(){
    Foo* Singleton_foo = Singleton<Foo>::instance();
    return 0;
}
