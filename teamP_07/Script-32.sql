SELECT * FROM MEMBER;

SELECT m.memnum, memid, memgrade, pftitle, pfnum, pfstatenum
FROM MEMBER m, MEMGRADE m2, PORTFOLIO p
WHERE m.memnum=p.memnum AND m.memgradenum = m2.memgradenum 
AND m.memgradenum=1 AND pfstatenum=1;
-- 0:등록중, 1: 제출, 2: 통과, 3:반려

SELECT memnum, memid, memnick, memreport, memjoindate, memgrade 
FROM MEMBER m, MEMGRADE m2 
WHERE m.memgradenum = m2.memgradenum
ORDER BY m.memgradenum;

UPDATE MEMBER m SET (memgradenum, memmodDate)=(
				SELECT memgradenum+1, sysdate 
				FROM MEMBER 
				WHERE memnum='mem-1022') 
		WHERE (memnum='mem-1022');
		
UPDATE MEMBER m SET (memgradenum, memmodDate)
				=(SELECT 1, sysdate FROM dual) 
		WHERE memnum IN ('mem-0002', 'mem-1005');
	
UPDATE PORTFOLIO m SET PFSTATENUM=1
		WHERE memnum IN ('mem-0002', 'mem-1005');	
	
INSERT INTO PORTFOLIO VALUES ('pfn-1005', 'mem-1005', '어쩌구 테스트 포트폴리오', '스티커 일러스트', '', '', 1);