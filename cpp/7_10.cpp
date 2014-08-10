RefCountPointer::type1(){
	incrementRefCounter();
}

RefCountPointer::type2(){
	decrementRefCounter();
	if (referenceCounterIsZero()){
	destructObject();
	}
}
