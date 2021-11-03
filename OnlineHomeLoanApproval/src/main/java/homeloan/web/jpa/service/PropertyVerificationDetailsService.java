package homeloan.web.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import homeloan.web.jpa.entity.PropertyVerificationDetails;
import homeloan.web.jpa.repository.PropertyVerificationDetailsRepository;

@Service
public class PropertyVerificationDetailsService
{
 @Autowired
 PropertyVerificationDetailsRepository propertyVerificationDetailsRepository;

 @Transactional(readOnly=true)
 public PropertyVerificationDetails getPropertyVerificationDetails(int verificationId)
 {
  Optional<PropertyVerificationDetails> a = propertyVerificationDetailsRepository.findById(verificationId);
  if(a.isPresent())
   return a.get();
  throw new RuntimeException("Property Verification Details Not found");
 }

 @Transactional(readOnly=true)
 public List<PropertyVerificationDetails> getPropertyVerificationDetailss()
 {
  List<PropertyVerificationDetails> plist = propertyVerificationDetailsRepository.findAll();
  if(plist.size() > 0)
   return plist;
  throw new RuntimeException("Not Found");
 }
 
 @Transactional
 public boolean addOrModifyPropertyVerificationDetails(PropertyVerificationDetails propertyVerificationDetails)
 {
  PropertyVerificationDetails pro = propertyVerificationDetailsRepository.save(propertyVerificationDetails);
  return pro!=null;
 }
 
 @Transactional
 public void removePropertyVerificationDetails(int verificationId)
 {
  propertyVerificationDetailsRepository.deleteById(verificationId);
 }
}